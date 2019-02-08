package rs.ftn.isa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.isa.dto.AirlineDTO;
import rs.ftn.isa.dto.BookingFlightDTO;
import rs.ftn.isa.dto.FlightDTO;
import rs.ftn.isa.model.Airline;
import rs.ftn.isa.model.BookingFlight;
import rs.ftn.isa.model.Flight;
import rs.ftn.isa.model.Seat;
import rs.ftn.isa.model.Stop;
import rs.ftn.isa.model.User;
import rs.ftn.isa.repository.FlightBookingRepository;
import rs.ftn.isa.service.BookingFlightService;
import rs.ftn.isa.service.EmailService;
import rs.ftn.isa.service.FlightService;
import rs.ftn.isa.service.SeatService;
import rs.ftn.isa.service.UserService;

@RestController
@RequestMapping("/api/bookingFlights")
public class BookingFlightController {

	@Autowired
	private BookingFlightService bookingFlightService;
	
	@Autowired
	private SeatService seatService;
	
	@Autowired
	private FlightService flightService;	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private FlightBookingRepository flightBookingRepository;
	
	@RequestMapping("/{id}")
	public ResponseEntity<BookingFlightDTO> getBookingById(@PathVariable Long id) {
		BookingFlight bookingFlight = flightBookingRepository.getOne(id);
		if(bookingFlight != null) {
			BookingFlightDTO bookingFlightDTO = new BookingFlightDTO(bookingFlight);
			return new ResponseEntity<BookingFlightDTO>(bookingFlightDTO, HttpStatus.OK);
		}
		return null;
	}
	
	
	@RequestMapping("/all")
	public ResponseEntity<List<BookingFlightDTO>> getAll() {
		List<BookingFlight> bookingFlight = bookingFlightService.getAll();
		if(bookingFlight != null) {
			List<BookingFlightDTO> bookingFlightDTO = new ArrayList<>();
			for(BookingFlight a : bookingFlight) {
				bookingFlightDTO.add(new BookingFlightDTO(a));
			}
			return new ResponseEntity<List<BookingFlightDTO>>(bookingFlightDTO, HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping(value="/deleteBookingFlight/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteBookingFlight(@PathVariable Long id) {
		BookingFlight bookingFlight = bookingFlightService.getOne(id);
		
		
		bookingFlightService.delete(bookingFlight);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/allSpecialOffers")
	public ResponseEntity<List<BookingFlightDTO>> getAllSpecialOffers() {
		List<BookingFlight> bookingFlight = flightBookingRepository.findByStatus("spec_offer");
		if(bookingFlight != null) {
			List<BookingFlightDTO> bookingFlightDTO = new ArrayList<>();
			for(BookingFlight a : bookingFlight) {
				bookingFlightDTO.add(new BookingFlightDTO(a));
			}
			return new ResponseEntity<List<BookingFlightDTO>>(bookingFlightDTO, HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
	public ResponseEntity<BookingFlightDTO> addBookingFlight(@RequestBody BookingFlightDTO bookingFlightDTO, @PathVariable Long id) throws ParseException {
		BookingFlight newBookingFlight = new BookingFlight();
		if(bookingFlightDTO != null) {
			Flight flight = flightService.getOne(id);
			System.out.println(flight.getId() + " id flight");
			float totalPrice = flight.getPrice();
			newBookingFlight.setFlight(flight);
				
			Seat seat = seatService.getOne(bookingFlightDTO.getSeats().getId());
			seat.setReserved(true);
			seatService.save(seat);
			newBookingFlight.setSeats(seat);
			
			newBookingFlight.setPassport_nmb(bookingFlightDTO.getPassport_nmb());
								
			newBookingFlight.setTotalPrice(totalPrice);
			
			Date res = new SimpleDateFormat("yyyy-MM-dd").parse(bookingFlightDTO.getReservationDate());
			newBookingFlight.setReservationDate(res);
			
			newBookingFlight.setStatus(bookingFlightDTO.getStatus());
			System.out.println("STIGNEM?");
			String email = bookingFlightDTO.getEmail();
			List<User> users = userService.getAll();
			for(User u : users) {
				if(u.getEmail().equals(email)) {					
					newBookingFlight.setUser(userService.getOne(u.getId()));
				}
			}		
									
			bookingFlightService.save(newBookingFlight);
			emailService.SendEmail(newBookingFlight.getUser().getEmail(), newBookingFlight);
			return new ResponseEntity<BookingFlightDTO>(new BookingFlightDTO(newBookingFlight), HttpStatus.OK);
						
		}
		
		return null;
	}
	
	@RequestMapping(value="/editBookingFlight/{id}", method=RequestMethod.PUT)
	public ResponseEntity<BookingFlightDTO> update(@RequestBody BookingFlightDTO bookingFlight, @PathVariable Long id) throws ParseException{
		System.out.println(bookingFlight.getFlight().getAirline_id() + " AIRlineID");
		BookingFlight oldBookingFlight = bookingFlightService.getOne(id);
		
		if(oldBookingFlight != null) {			
			String email = bookingFlight.getEmail();
			List<User> users = userService.getAll();
			for(User u : users) {
				if(u.getEmail().equals(email)) {					
					oldBookingFlight.setUser(userService.getOne(u.getId()));
				}
			}
			
			Date res = new SimpleDateFormat("yyyy-MM-dd").parse(bookingFlight.getReservationDate());
			oldBookingFlight.setReservationDate(res);
			
			oldBookingFlight.setPassport_nmb(bookingFlight.getPassport_nmb());
			
			oldBookingFlight.setTotalPrice(bookingFlight.getFlight().getPrice());
			
			oldBookingFlight.setStatus(bookingFlight.getStatus());
			
			bookingFlightService.save(oldBookingFlight);
			
			return new ResponseEntity<BookingFlightDTO>(new BookingFlightDTO(oldBookingFlight), HttpStatus.OK);
		}else {
			return null;
		}
	}
	
	
	@RequestMapping(value = "/invite/{email}", method = RequestMethod.POST)
	public ResponseEntity<BookingFlightDTO> inviteBookingFlight(@RequestBody BookingFlightDTO bookingFlightDTO, @PathVariable String email) throws ParseException, MessagingException {
		BookingFlight newBookingFlight = new BookingFlight();
		if(bookingFlightDTO != null) {
			Flight flight = flightService.getOne(bookingFlightDTO.getFlight().getId());
			System.out.println(flight.getId() + " id flight");
			float totalPrice = flight.getPrice();
			newBookingFlight.setFlight(flight);
				
			Seat seat = seatService.getOne(bookingFlightDTO.getSeats().getId());
			seat.setReserved(true);
			seatService.save(seat);
			newBookingFlight.setSeats(seat);
			
			newBookingFlight.setPassport_nmb(bookingFlightDTO.getPassport_nmb());
								
			newBookingFlight.setTotalPrice(totalPrice);
			
			Date res = new SimpleDateFormat("yyyy-MM-dd").parse(bookingFlightDTO.getReservationDate());
			newBookingFlight.setReservationDate(res);
			
			newBookingFlight.setStatus(bookingFlightDTO.getStatus());
			
			String receiverEmail = bookingFlightDTO.getEmail();
			List<User> users = userService.getAll();
			for(User u : users) {
				if(u.getEmail().equals(receiverEmail)) {					
					newBookingFlight.setUser(userService.getOne(u.getId()));
				}
			}		
									
			bookingFlightService.save(newBookingFlight);
			emailService.InviteEmail(receiverEmail,  newBookingFlight, email);
			return new ResponseEntity<BookingFlightDTO>(new BookingFlightDTO(newBookingFlight), HttpStatus.OK);
						
		}
		
		return null;
	}
	
	@RequestMapping(value="/decline/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> declineInvitation(@PathVariable Long id) {
		BookingFlight bf = flightBookingRepository.getOne(id);
		Seat s = bf.getSeats();
		s.setReserved(false);
		seatService.save(s);
		flightBookingRepository.delete(bf);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/accept/{id}/{passport}", method = RequestMethod.GET)
	public ResponseEntity<?> acceptInvitation(@PathVariable Long id, @PathVariable float passport) {
		BookingFlight bf = flightBookingRepository.getOne(id);
		bf.setStatus("accepted");
		bf.setPassport_nmb(passport);
		bookingFlightService.save(bf);
		emailService.SendEmail(bf.getUser().getEmail(), bf);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
