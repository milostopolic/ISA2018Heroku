package rs.ftn.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rs.ftn.isa.model.Airline;
import rs.ftn.isa.model.Flight;
import rs.ftn.isa.model.Stop;
import rs.ftn.isa.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private StopService stopService;
	
	@Override
	public Flight getOne(Long id) {
		// TODO Auto-generated method stub
		return flightRepository.getOne(id);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public Flight save(Flight flight) {
		// TODO Auto-generated method stub
		return flightRepository.save(flight);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void delete(Flight flight) {
		// TODO Auto-generated method stub
		flightRepository.delete(flight);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public Flight update(Flight oldFlight, Flight newFlight) {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^6");
		// TODO Auto-generated method stub
		if(newFlight.getDeparturePlace() != null) {
			oldFlight.setDeparturePlace(newFlight.getDeparturePlace());
		}
		if(newFlight.getDestination() != null) {
			oldFlight.setDestination(newFlight.getDestination());
		}
		if(newFlight.getTakeOffDate() != null) {
			oldFlight.setTakeOffDate(newFlight.getTakeOffDate().substring(0, 10));
			System.out.println(oldFlight.getTakeOffDate() + " AALDKLSKDSKDSKDSKDSKKDSKDS");
		}
		if(newFlight.getTakeOffTime() != null) {
			oldFlight.setTakeOffTime(newFlight.getTakeOffTime());
		}
		if(newFlight.getLandDate() != null) {
			oldFlight.setLandDate(newFlight.getLandDate().substring(0, 10));
			System.out.println(oldFlight.getLandDate() + " LDKLSKDSKDSKDSKDSKKDSKDS");
		}
		if(newFlight.getLandTime() != null) {
			System.out.println(newFlight.getLandTime() + " ALO");
			oldFlight.setLandTime(newFlight.getLandTime());
		}
		if(newFlight.getDistance() != 0) {
			oldFlight.setDistance(newFlight.getDistance());
		}
		if(newFlight.getDistance() != 0) {
			oldFlight.setDistance(newFlight.getDistance());
		}
		//oldFlight.setStops(newFlight.getStops()); // ovde stopovi impl
		
		List<Stop> st = new ArrayList<Stop>();
		if(newFlight.getStops() != null){
			for(int i = 0; i < newFlight.getStops().size();i++){
				Stop s = new Stop();
				s.setName(newFlight.getStops().get(i).getName());
				s.setId(newFlight.getStops().get(i).getId());
				st.add(s);
			}
		}else{
			
		}
		oldFlight.setStops(st);
			
		for(int i = 0; i < newFlight.getStops().size();i++){
			Stop s = new Stop();
			s.setName(newFlight.getStops().get(i).getName());
			s.setFlight(oldFlight);
			s = stopService.save(s);
		}
		
		System.out.println(newFlight.getStops() + " LISTA STOPOVA");
		if(newFlight.getPrice() != 0) {
			oldFlight.setPrice(newFlight.getPrice());
		}
		
		
		return flightRepository.save(oldFlight);
	}

	@Override
	public List<Flight> getAll() {
		// TODO Auto-generated method stub
		return flightRepository.findAll();
	}

}
