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

import rs.ftn.isa.dto.AirlineDTO;
import rs.ftn.isa.dto.RentACarDTO;
import rs.ftn.isa.model.Airline;
import rs.ftn.isa.model.RentACar;
import rs.ftn.isa.service.RentACarService;

@RestController
@RequestMapping("/api/rentacars")
//@CrossOrigin(origins = "http://localhost:4200")
public class RentACarController {
	
	@Autowired
	private RentACarService rentACarService;
	
	@RequestMapping("/{id}")
	public ResponseEntity<RentACarDTO> getRentACarById(@PathVariable Long id) {
		RentACar rentACar = rentACarService.getOne(id);
		if(rentACar != null) {
			RentACarDTO rentACarDTO = new RentACarDTO(rentACar);
			return new ResponseEntity<RentACarDTO>(rentACarDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping("/all")
	public ResponseEntity<List<RentACarDTO>> getAll() {
		List<RentACar> rentACars = rentACarService.getAll();
		if(rentACars != null) {
			List<RentACarDTO> rentACarsDTO = new ArrayList<RentACarDTO>();
			for(RentACar r : rentACars) {
				rentACarsDTO.add(new RentACarDTO(r));
			}
			return new ResponseEntity<List<RentACarDTO>>(rentACarsDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<RentACarDTO> addRentACar(@RequestBody RentACarDTO racDTO) {
		RentACar newRac = new RentACar();
		if(racDTO != null) {
			newRac.setName(racDTO.getName());
			newRac.setAddress(racDTO.getAddress());
			newRac.setDescription(racDTO.getDescription());
			newRac.setBranches(new ArrayList<>());
			newRac.setVehicles(new ArrayList<>());
			newRac.setImage("../../assets/img/car.jpg");
			
			RentACar rac = rentACarService.save(newRac);
			
			return new ResponseEntity<RentACarDTO>(new RentACarDTO(rac), HttpStatus.CREATED);
		}
		
		return null;
	}
	
	
	@RequestMapping(value="/addadmin/{rac_id}/{admin_id}", method=RequestMethod.GET)
	public ResponseEntity<RentACarDTO> addAdmin(@PathVariable Long rac_id, @PathVariable Long admin_id) {
		RentACar rac = rentACarService.getOne(rac_id);
		if(rac != null) {
			rac.setAdmin_id(admin_id);
			
			rentACarService.save(rac);
			return new ResponseEntity<RentACarDTO>(new RentACarDTO(rac), HttpStatus.OK);
		}
		return null;
	}

}
