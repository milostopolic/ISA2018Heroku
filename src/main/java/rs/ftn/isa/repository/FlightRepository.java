package rs.ftn.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rs.ftn.isa.dto.FlightDTO;
import rs.ftn.isa.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>   {
	
	@Modifying
	@Query("select flight from Flight flight where (flight.departurePlace = ?1 and flight.destination = ?2 and flight.takeOffDate = ?3) or (flight.destination = ?1 and flight.departurePlace = ?2 and flight.takeOffDate = ?4)")
	List<Flight> searchReturnFlights(String departurePlace, String destination, String takeOffDate, String landDate);
	
	@Modifying
	@Query("select flight from Flight flight where flight.departurePlace = ?1 and flight.destination = ?2 and flight.takeOffDate = ?3")
	List<Flight> searchFlights(String departurePlace, String destination, String takeOffDate);
	
	
	//List<Flight> findByDeparturePlaceAndDestinationAndTakeOffDateAndLandDate(String departurePlace, String destination, String takeOffDate, String landDate);
}
