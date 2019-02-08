package rs.ftn.isa.service;

import java.util.List;


import rs.ftn.isa.model.Flight;

public interface FlightService {

	Flight getOne(Long id);
	Flight save(Flight flight);
	void delete(Flight flight);
	Flight update(Flight oldFlight, Flight newFlight);
	List<Flight> getAll();
	
}
