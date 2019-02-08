package rs.ftn.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ftn.isa.model.BookingFlight;

@Repository
public interface FlightBookingRepository extends JpaRepository<BookingFlight, Long> {

	List<BookingFlight> findByStatus(String status);
	
}
