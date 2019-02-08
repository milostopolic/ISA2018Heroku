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

import rs.ftn.isa.dto.AdditionalServiceDTO;
import rs.ftn.isa.dto.BookingDTO;
import rs.ftn.isa.dto.RoomDTO;
import rs.ftn.isa.model.Booking;
import rs.ftn.isa.model.Hotel;
import rs.ftn.isa.model.HotelBookingInfo;
import rs.ftn.isa.model.Room;
import rs.ftn.isa.model.User;
import rs.ftn.isa.service.AdditionalServiceService;
import rs.ftn.isa.service.BookingService;
import rs.ftn.isa.service.HotelService;
import rs.ftn.isa.service.RoomService;
import rs.ftn.isa.service.UserService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private AdditionalServiceService additionalServiceService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/showrooms/{id}", method=RequestMethod.POST)
	public ResponseEntity<List<RoomDTO>> showAvailableRooms(@PathVariable Long id, @RequestBody HotelBookingInfo info) {
		System.out.println("`````````````````````````````````````````````````````````");
		System.out.println(info.getRooms());
		System.out.println(info.getPersons());
		System.out.println(info.getsDate());
		System.out.println("`````````````````````````````````````````````````````````");
		List<Room> roomsInHotel = roomService.findByHotel_Id(id);
		List<Booking> bookingsInInterval = bookingService.findBookingsInInterval(id, info.getsDate(), info.geteDate());
		
		List<Room> freeRooms = new ArrayList<>();
		
		for(Room r : roomsInHotel) {
			boolean free = true;
			for(Booking b : bookingsInInterval) {
				if(b.getRooms().contains(r)) {
					free = false;
				}
			}
			
			if(free && !r.isOnDiscount()) {
				freeRooms.add(r);
			}
		}
		
		int roomsCapacity = 0;
		for(Room r : freeRooms) {
			roomsCapacity += r.getBeds();
		}
		
		if(freeRooms.size() < info.getRooms()) {
			System.out.println("Not enough rooms.");
			return new ResponseEntity<List<RoomDTO>>(new ArrayList<RoomDTO>(), HttpStatus.OK);
		} else if(roomsCapacity < info.getPersons()) {
			System.out.println("Not enough rooms capacity.");
			return new ResponseEntity<List<RoomDTO>>(new ArrayList<RoomDTO>(), HttpStatus.OK);
		} else {
			List<RoomDTO> roomsDTO = new ArrayList<>();
			for(Room r : freeRooms) {
				roomsDTO.add(new RoomDTO(r));
			}
			System.out.println(roomsDTO.size());
			return new ResponseEntity<List<RoomDTO>>(roomsDTO, HttpStatus.OK);
		}	
		
	}
	
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
	public ResponseEntity<BookingDTO> addBooking(@RequestBody BookingDTO bookingDTO, @PathVariable Long id) {
		Booking newBooking = new Booking();
		System.out.println("DUZINA SOBA" + bookingDTO.getRooms().size());
		if(bookingDTO != null) {
			Hotel hotel = hotelService.getOne(id);
			//float totalPrice = 0;
			//System.out.println("PRVI PUT" + totalPrice);
			newBooking.setHotel(hotel);
			
			for(RoomDTO r : bookingDTO.getRooms()) {
				newBooking.getRooms().add(roomService.getOne(r.getId()));
				//totalPrice += roomService.getOne(r.getId()).getPrice();
				//System.out.println("U PETLJI ZAZ SOBE" + totalPrice);
			}
			int b = 0;
			for(AdditionalServiceDTO as : bookingDTO.getAdditionalServices()) {
				System.out.println("ADDITIONAL " + ++b);
				newBooking.getAdditionalServices().add(additionalServiceService.getOne(as.getId()));
				System.out.println(additionalServiceService.getOne(as.getId()).getName());
				//totalPrice += additionalServiceService.getOne(as.getId()).getPrice();
				//System.out.println("U PETLJI ZA AS" + totalPrice);
			}
			System.out.println("ADDITIONAL SIZE " + newBooking.getAdditionalServices().size());
			
			newBooking.setTotalPrice(bookingDTO.getTotalPrice());
			
			newBooking.setStartDate(bookingDTO.getsDate());
			newBooking.setEndDate(bookingDTO.geteDate());
			
			String email = bookingDTO.getEmail();
			List<User> users = userService.getAll();
			for(User u : users) {
				if(u.getEmail().equals(email)) {
					newBooking.setUser(userService.getOne(u.getId()));
				}
			}		
			
			
			
			
			bookingService.save(newBooking);
			
			return new ResponseEntity<BookingDTO>(new BookingDTO(newBooking), HttpStatus.OK);
			
		}
		
		return null;
	}
	
	@RequestMapping("/all")
	public ResponseEntity<List<BookingDTO>> getAllBookings() {
		List<Booking> bookings = bookingService.getAll();
		if(bookings != null) {
			List<BookingDTO> bookingsDTO = new ArrayList<>();
			for(Booking b : bookings) {
				bookingsDTO.add(new BookingDTO(b));
			}
			return new ResponseEntity<List<BookingDTO>>(bookingsDTO, HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping("/allbyhotel/{id}")
	public ResponseEntity<List<BookingDTO>> findAllBookingsByHotel(@PathVariable Long id) {
		Hotel hotel = hotelService.getOne(id);
		if(hotel != null) {
			List<Booking> bookings = bookingService.findByHotel(hotel.getId());
			List<BookingDTO> bDTO = new ArrayList<>();
			for(Booking b : bookings) {
				bDTO.add(new BookingDTO(b));
			}
			
			return new ResponseEntity<List<BookingDTO>>(bDTO, HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping("/usernull/{id}")
	public ResponseEntity<List<BookingDTO>> findAllBookingsByHotelAndUserIsNull(@PathVariable Long id) {
		System.out.println("USAO U USER NULL  " + id);
		Hotel hotel = hotelService.getOne(id);
		System.out.println("NE PUCA");
		if(hotel != null) {
			List<Booking> bookings = bookingService.findByHotelAndUserIsNull(hotel.getId());
			List<BookingDTO> bDTO = new ArrayList<>();
			for(Booking b : bookings) {
				//bDTO.add(new BookingDTO(b.getRooms()));
				bDTO.add(new BookingDTO(b));
			}
			System.out.println("IMA IH " + bDTO.size());
			
			return new ResponseEntity<List<BookingDTO>>(bDTO, HttpStatus.OK);
		}
		return null;
	}
	
	
	@RequestMapping(value="/fastbook", method=RequestMethod.POST)
	public ResponseEntity<BookingDTO> fastBook(@RequestBody BookingDTO bDTO) {
		System.out.println("Usao u control");
		Booking booking = bookingService.getOne(bDTO.getId());
		System.out.println("Nasao je b");
		if(booking != null) {
			booking.setStartDate(bDTO.getsDate());
			booking.setEndDate(bDTO.geteDate());
			booking.setTotalPrice(bDTO.getTotalPrice());
			
			String email = bDTO.getEmail();
			List<User> users = userService.getAll();
			for(User u : users) {
				if(u.getEmail().equals(email)) {
					booking.setUser(userService.getOne(u.getId()));
				}
			}		
			
			bookingService.save(booking);
			
			return new ResponseEntity<BookingDTO>(new BookingDTO(booking), HttpStatus.OK);
		}
		
		return null;
	}
	
	

}
