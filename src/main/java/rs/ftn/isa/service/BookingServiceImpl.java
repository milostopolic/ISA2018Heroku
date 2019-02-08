package rs.ftn.isa.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rs.ftn.isa.model.Booking;
import rs.ftn.isa.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public List<Booking> findBookingsInInterval(Long id, Date startDate, Date endDate) {
		return bookingRepository.findBookingsInInterval(id, startDate, endDate);
	}

	@Override
	public Booking getOne(Long id) {
		return bookingRepository.getOne(id);
	}

	@Override
	public List<Booking> getAll() {
		return bookingRepository.findAll();
	}

	@Override
	@Transactional
	public Booking save(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> findByHotel(Long id) {
		return bookingRepository.findByHotel(id);
	}

	@Override
	public List<Booking> findByHotelAndUserIsNull(Long id) {
		return bookingRepository.findByHotelAndUserIsNull(id);
	}

}
