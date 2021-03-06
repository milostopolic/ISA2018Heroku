package rs.ftn.isa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.isa.dto.HotelDTO;
import rs.ftn.isa.model.Hotel;
import rs.ftn.isa.model.Pricelist;
import rs.ftn.isa.repository.HotelRepository;
import rs.ftn.isa.service.AdditionalServiceService;
import rs.ftn.isa.service.HotelService;
import rs.ftn.isa.service.PricelistService;

@RestController
@RequestMapping("/api/hotels")
//@CrossOrigin(origins = "http://localhost:4200")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private PricelistService pricelistService;
	
	@Autowired
	private AdditionalServiceService additionalServiceService;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@RequestMapping("/{id}")
	public ResponseEntity<HotelDTO> getHotelById(@PathVariable Long id) {
		Hotel hotel = hotelService.getOne(id);
		if(hotel != null) {
			HotelDTO hotelDTO = new HotelDTO(hotel);
			return new ResponseEntity<HotelDTO>(hotelDTO, HttpStatus.OK);
		}
		return null;
	} 
	
	@RequestMapping("/all")
	public ResponseEntity<List<HotelDTO>> getAll() {
		List<Hotel> hotels = hotelService.getAll();
		if(hotels != null) {
			List<HotelDTO> hotelsDTO = new ArrayList<>();
			for(Hotel h : hotels) {
				hotelsDTO.add(new HotelDTO(h));
			}
			return new ResponseEntity<List<HotelDTO>>(hotelsDTO, HttpStatus.OK);
		}
		return null;
	}
	
	/*@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public ResponseEntity<HotelDTO> update(@RequestBody Hotel hotelDTO, @PathVariable Long id) {
		Hotel hotel = hotelService.getOne(id);		
		if(hotelDTO != null) {
			hotel.setName(hotelDTO.getName());
			hotel.setAddress(hotelDTO.getAddress());
			hotel.setDescription(hotelDTO.getDescription());
			
			hotelService.save(hotel);
			
			HotelDTO newHotelDTO = new HotelDTO(hotel);
			return new ResponseEntity<HotelDTO>(newHotelDTO, HttpStatus.OK);
		}
		return null;
	}*/
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public ResponseEntity<HotelDTO> update(@RequestBody Hotel hotel, @PathVariable Long id) {
		Hotel oldHotel = hotelService.getOne(id);		
		if(oldHotel != null) {
			Hotel newHotel = hotelService.update(oldHotel, hotel);
			return new ResponseEntity<HotelDTO>(new HotelDTO(newHotel), HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping("/searchbyaddress/{criteria}")
	public ResponseEntity<List<HotelDTO>> searchHotelsByAddress(@PathVariable String criteria) {
		List<Hotel> hotels = hotelRepository.findByAddressContaining(criteria);
		if(hotels != null) {
			List<HotelDTO> hotelsDTO = new ArrayList<>();
			for(Hotel h : hotels) {
				hotelsDTO.add(new HotelDTO(h));
			}
			return new ResponseEntity<List<HotelDTO>>(hotelsDTO, HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping("/searchbyname/{criteria}")
	public ResponseEntity<HotelDTO> searchHotelByName(@PathVariable String criteria) {
		Hotel hotel = hotelRepository.findByName(criteria);
		if(hotel != null) {
			return new ResponseEntity<HotelDTO>(new HotelDTO(hotel), HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<HotelDTO> addHotel(@RequestBody HotelDTO hotelDTO) {
		Hotel newHotel = new Hotel();
		if(hotelDTO != null) {
			newHotel.setName(hotelDTO.getName());
			newHotel.setAddress(hotelDTO.getAddress());
			newHotel.setDescription(hotelDTO.getDescription());
			newHotel.setImage("../../assets/img/hotel.jpg");
			newHotel.setPricelist(new Pricelist());
			newHotel.getPricelist().setAdditionalServices(new ArrayList<>());
			newHotel.setRooms(new ArrayList<>());
			//additionalServiceService.saveAll(newHotel.getPricelist().getAdditionalServices());
			Pricelist newPl = pricelistService.save(newHotel.getPricelist());			
			newHotel = hotelService.save(newHotel);
			
			newPl.setHotel(newHotel);
			pricelistService.save(newPl);	
			
			return new ResponseEntity<HotelDTO>(new HotelDTO(newHotel), HttpStatus.OK);			
		}
		return null;
	}
	
	@RequestMapping(value="/addadmin/{hotel_id}/{admin_id}", method=RequestMethod.GET)
	public ResponseEntity<HotelDTO> addAdmin(@PathVariable Long hotel_id, @PathVariable Long admin_id) {
		Hotel hotel = hotelService.getOne(hotel_id);
		if(hotel != null) {
			hotel.setAdmin_id(admin_id);
			
			hotelService.save(hotel);
			return new ResponseEntity<HotelDTO>(new HotelDTO(hotel), HttpStatus.OK);
		}
		return null;
	}
}
