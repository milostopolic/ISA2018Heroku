package rs.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ftn.isa.model.BookingFlight;
import rs.ftn.isa.repository.FlightBookingRepository;

@Service
public class BookingFlightServiceImpl implements BookingFlightService {

	@Autowired
	private FlightBookingRepository bookingFlightRepository;

	@Override
	public BookingFlight getOne(Long id) {
		// TODO Auto-generated method stub
		return bookingFlightRepository.getOne(id);
	}

	@Override
	public List<BookingFlight> getAll() {
		// TODO Auto-generated method stub
		return bookingFlightRepository.findAll();
	}

	@Transactional(readOnly = false)
	@Override
	public BookingFlight save(BookingFlight bookingFlight) {
		// TODO Auto-generated method stub
		return bookingFlightRepository.save(bookingFlight);
	}

	@Transactional(readOnly = false)
	@Override
	public BookingFlight update(BookingFlight oldBookingFlight, BookingFlight newBookingFlight) {
		System.out.println("OVDEEEEEEEEEEEEEEEEEEEEEEEEEEEE SAM!@#@!#!@#!@");
		// TODO Auto-generated method stub
		if(newBookingFlight.getPassport_nmb() != 0) {
			oldBookingFlight.setPassport_nmb(newBookingFlight.getPassport_nmb());
		}
		if(newBookingFlight.getReservationDate() != null) {
			oldBookingFlight.setReservationDate(newBookingFlight.getReservationDate());
		}
		if(newBookingFlight.getFlight() != null) {
			oldBookingFlight.setFlight(newBookingFlight.getFlight());
		}
		if(newBookingFlight.getStatus() != null) {
			oldBookingFlight.setStatus(newBookingFlight.getStatus());
		}
		if(newBookingFlight.getTotalPrice() != 0) {
			oldBookingFlight.setTotalPrice(newBookingFlight.getTotalPrice());
		}
		if(newBookingFlight.getSeats() != null) {
			oldBookingFlight.setSeats(newBookingFlight.getSeats());
		}
		if(newBookingFlight.getUser() != null) {
			oldBookingFlight.setUser(newBookingFlight.getUser());
		}
		
		
		return bookingFlightRepository.save(oldBookingFlight);
	}

	@Override
	public List<BookingFlight> findByStatus(String status) {
		// TODO Auto-generated method stub
		return bookingFlightRepository.findByStatus(status);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(BookingFlight bookingFlight) {
		// TODO Auto-generated method stub
		bookingFlightRepository.delete(bookingFlight);
	}
	
	
}
