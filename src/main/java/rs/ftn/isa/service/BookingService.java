package rs.ftn.isa.service;

import java.util.Date;
import java.util.List;

import rs.ftn.isa.model.Booking;

public interface BookingService {
	
	List<Booking> findBookingsInInterval(Long id, Date startDate, Date endDate);
	Booking getOne(Long id);
	List<Booking> getAll();
	Booking save(Booking booking);
	List<Booking> findByHotel(Long id);
	List<Booking> findByHotelAndUserIsNull(Long id);
	
}
