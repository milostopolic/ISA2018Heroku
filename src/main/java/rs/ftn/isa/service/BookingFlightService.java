package rs.ftn.isa.service;

import java.util.List;

import rs.ftn.isa.model.BookingFlight;
import rs.ftn.isa.model.Flight;
import rs.ftn.isa.model.Hotel;

public interface BookingFlightService {

	BookingFlight getOne(Long id);
	List<BookingFlight> getAll();
	BookingFlight save(BookingFlight bookingFlight);
	BookingFlight update(BookingFlight oldBookingFlight,BookingFlight newBookingFlight);
	List<BookingFlight> findByStatus(String status);
	void delete(BookingFlight bookingFlight);
}
