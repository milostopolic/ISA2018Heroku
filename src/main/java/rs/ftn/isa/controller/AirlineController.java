package rs.ftn.isa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.isa.dto.AirlineDTO;
import rs.ftn.isa.dto.DestinationDTO;
import rs.ftn.isa.dto.FlightDTO;
import rs.ftn.isa.dto.HotelDTO;
import rs.ftn.isa.dto.SeatDTO;
import rs.ftn.isa.dto.StopDTO;
import rs.ftn.isa.model.Airline;
import rs.ftn.isa.model.Destination;
import rs.ftn.isa.model.Flight;
import rs.ftn.isa.model.Hotel;
import rs.ftn.isa.model.Seat;
import rs.ftn.isa.model.Stop;
import rs.ftn.isa.repository.FlightRepository;
import rs.ftn.isa.service.AirlineService;
import rs.ftn.isa.service.DestinationService;
import rs.ftn.isa.service.EmailService;
import rs.ftn.isa.service.FlightService;
import rs.ftn.isa.service.SeatService;
import rs.ftn.isa.service.StopService;

@RestController
@RequestMapping("/api/airlines")
@CrossOrigin(origins = "http://localhost:4200")
public class AirlineController {
	
	@Autowired
	private AirlineService airlineService;
	
	@Autowired
	private DestinationService destinationService;
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private StopService stopService;
	
	@Autowired
	private SeatService seatService;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/{id}")
	public ResponseEntity<AirlineDTO> getAirlineById(@PathVariable Long id) {
		Airline airline = airlineService.getOne(id);
		if(airline != null) {
			AirlineDTO airlineDTO = new AirlineDTO(airline);
			return new ResponseEntity<AirlineDTO>(airlineDTO, HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping("/all")
	public ResponseEntity<List<AirlineDTO>> getAll() {
		List<Airline> airlines = airlineService.getAll();
		if(airlines != null) {
			List<AirlineDTO> airlinesDTO = new ArrayList<>();
			for(Airline a : airlines) {
				airlinesDTO.add(new AirlineDTO(a));
			}
			return new ResponseEntity<List<AirlineDTO>>(airlinesDTO, HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public ResponseEntity<AirlineDTO> update(@RequestBody Airline airline, @PathVariable Long id){
		Airline oldAirline = airlineService.getOne(id);		
		if(oldAirline != null) {
			Airline newAirline = airlineService.update(oldAirline, airline);
			return new ResponseEntity<AirlineDTO>(new AirlineDTO(newAirline), HttpStatus.OK);
		}
			return null;
		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<AirlineDTO> addAirline(@RequestBody AirlineDTO airDTO){
		Airline air = new Airline();
		if(airDTO != null) {
			air.setAddress(airDTO.getAddress());
			air.setDescription(airDTO.getDescription());
			air.setName(airDTO.getName());
			air.setDestinations(new ArrayList<Destination>());
			air.setFlights(new ArrayList<>());
			air.setImage("../../assets/img/airplane.png");
			air = airlineService.save(air);
			return new ResponseEntity<AirlineDTO>(new AirlineDTO(air), HttpStatus.CREATED);
		}
		return null;
	}
	
							/* DESTINATION CONTROLLER */
	
	@RequestMapping(value = "/addDestination/{id}", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)	
		public ResponseEntity<DestinationDTO> addDestinationToAirline(@RequestBody DestinationDTO destDTO, @PathVariable Long id){
			Destination destin = new Destination();
			destin.setName(destDTO.getName());
			Airline air = airlineService.getOne(id);
			destin.setAirline(air);
			destin = destinationService.save(destin);
			air.getDestinations().add(destin);
			air = airlineService.save(air);
			return new ResponseEntity<DestinationDTO>(new DestinationDTO(destin), HttpStatus.CREATED);
		}
	
	@RequestMapping(value="/deleteDestination/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteDestination(@PathVariable Long id) {
		destinationService.delete(destinationService.getOne(id));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/editDestination/{id}", method=RequestMethod.PUT)
	public ResponseEntity<DestinationDTO> update(@RequestBody Destination destination, @PathVariable Long id){
		Destination oldDestination = destinationService.getOne(id);
		Airline airl = airlineService.getOne(oldDestination.getAirline().getId());
		if(oldDestination != null) {
			for(Destination d : airl.getDestinations()) {
				System.out.println(d.getName() + " " + destination.getName() + "!!!!!!!!!!!!!!!!!");
				if(d.getName().equals(destination.getName())) {
					System.out.println("usao!!#@#@#@");
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			Destination newDestination = destinationService.update(oldDestination, destination);
			return new ResponseEntity<DestinationDTO>(new DestinationDTO(newDestination), HttpStatus.OK);
		}else {
			return null;
		}
	}
	
							/* STOP CONTROLLER */
	
	@RequestMapping(value="/allStops")
		public ResponseEntity<List<StopDTO>> getAllStops(){
		List<Stop> stops = stopService.getAll();
		if(stops != null) {
			List<StopDTO> stopsDTO = new ArrayList<>();
			for(Stop s : stops) {
				stopsDTO.add(new StopDTO(s));
			}
			return new ResponseEntity<List<StopDTO>>(stopsDTO, HttpStatus.OK);
		}
		return null;
	}
						
						/* SEAT CONTROLLER */
	
	@RequestMapping(value="/allSeats")
	public ResponseEntity<List<SeatDTO>> getAllSeats(){
	List<Seat> seats = seatService.getAll();
	if(seats != null) {
		List<SeatDTO> seatsDTO = new ArrayList<>();
		for(Seat s : seats) {
			seatsDTO.add(new SeatDTO(s));
		}
		return new ResponseEntity<List<SeatDTO>>(seatsDTO, HttpStatus.OK);
	}
	return null;
}
		
	
/* FLIGHT CONTROLLER */
	
	@RequestMapping(value="/allFlights")
	public ResponseEntity<List<FlightDTO>> getAllFlights(){
	List<Flight> flights = flightService.getAll();
	if(flights != null) {
		List<FlightDTO> flightDTO = new ArrayList<>();
		for(Flight f : flights) {
			flightDTO.add(new FlightDTO(f));
		}
		return new ResponseEntity<List<FlightDTO>>(flightDTO, HttpStatus.OK);
	}
	return null;
}
	
	@RequestMapping("/flight/{id}")
	public ResponseEntity<FlightDTO> getFlightById(@PathVariable Long id) {
		Flight flight = flightService.getOne(id);
		if(flight != null) {
			FlightDTO flightDTO = new FlightDTO(flight);
			return new ResponseEntity<FlightDTO>(flightDTO, HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping(value = "/addFlight/{id}", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)	
		public ResponseEntity<FlightDTO> addFlightToAirline(@RequestBody FlightDTO fligDTO, @PathVariable Long id){
			Flight flig = new Flight();
			flig.setDeparturePlace(fligDTO.getDeparturePlace());
			flig.setDestination(fligDTO.getDestination());
			flig.setTakeOffDate(fligDTO.getTakeOffDate().substring(0, 10));
			System.out.println(flig.getTakeOffDate() + " @22@#@#@#@#");
			flig.setTakeOffTime(fligDTO.getTakeOffTime());
			flig.setLandDate(fligDTO.getLandDate().substring(0, 10));
			flig.setLandTime(fligDTO.getLandTime());
			flig.setDistance(fligDTO.getDistance());
			List<Stop> st = new ArrayList<Stop>();
			if(fligDTO.getStops() != null){
				for(int i = 0; i < fligDTO.getStops().size();i++){
					Stop s = new Stop();
					s.setName(fligDTO.getStops().get(i).getName());
					s.setId(fligDTO.getStops().get(i).getId());
					st.add(s);
				}
			}else{
				
			}
			flig.setStops(st);
			flig.setPrice(fligDTO.getPrice());
			Airline air = airlineService.getOne(id);
			flig.setAirline(air);
			flig = flightService.save(flig);
			air.getFlights().add(flig);
			air = airlineService.save(air);
			
			for(int i = 0; i < fligDTO.getStops().size();i++){
				Stop s = new Stop();
				s.setName(fligDTO.getStops().get(i).getName());
				s.setFlight(flig);
				s = stopService.save(s);
			}
			
			return new ResponseEntity<FlightDTO>(new FlightDTO(flig), HttpStatus.CREATED);		
	}	
	
							
	
	@RequestMapping(value="/deleteFlight/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteFlight(@PathVariable Long id) {
		Flight flight = flightService.getOne(id);

		List<Stop> s = new ArrayList<Stop>();
		s = flight.getStops();
		for(int i = 0; i < s.size(); i++) {
			stopService.delete(s.get(i));
		}
		
		flightService.delete(flight);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/editFlight/{id}", method=RequestMethod.PUT)
	public ResponseEntity<FlightDTO> update(@RequestBody Flight flight, @PathVariable Long id){
		Flight oldFlight = flightService.getOne(id);
		//Airline airl = airlineService.getOne(oldFlight.getAirline().getId());
		if(oldFlight != null) {			
			Flight newFlight = flightService.update(oldFlight, flight);
			return new ResponseEntity<FlightDTO>(new FlightDTO(newFlight), HttpStatus.OK);
		}else {
			return null;
		}
	}
	
					/* FLIGHT CONTROLLER SEARCH */
	
	@RequestMapping(value="/searchFlights", method=RequestMethod.POST)
	public ResponseEntity<List<FlightDTO>> searchFlights(@RequestBody FlightDTO flightDTO){
		if(flightDTO.getLandDate() == null) {
			String departurePlace = flightDTO.getDeparturePlace();
			String destination = flightDTO.getDestination();
			String takeOffDate = flightDTO.getTakeOffDate().substring(0,10);
			System.out.println(departurePlace + " 1111111");
			System.out.println(destination);
			System.out.println(takeOffDate + " TAKE OFF DATE");
			List<FlightDTO> fligDTO = new ArrayList<>();
			for(Flight f : flightRepository.searchFlights(departurePlace, destination, takeOffDate)) {
				fligDTO.add(new FlightDTO(f));
			}
			
			return new ResponseEntity<List<FlightDTO>>(fligDTO, HttpStatus.OK);
		}else {
			String departurePlace = flightDTO.getDeparturePlace();
			String destination = flightDTO.getDestination();
			String takeOffDate = flightDTO.getTakeOffDate().substring(0,10);
			String landDate = flightDTO.getLandDate().substring(0, 10);
			System.out.println(departurePlace + " 1111111");
			System.out.println(destination);
			System.out.println(takeOffDate + " TAKE OFF DATE");
			System.out.println(landDate + " LAND DATE");
			List<FlightDTO> fligDTO = new ArrayList<>();
			for(Flight f : flightRepository.searchReturnFlights(departurePlace, destination, takeOffDate, landDate)) {
				fligDTO.add(new FlightDTO(f));
			}
			
			return new ResponseEntity<List<FlightDTO>>(fligDTO, HttpStatus.OK);
			
		}
		
	}
	
	@RequestMapping(value="/addadmin/{airline_id}/{admin_id}", method=RequestMethod.GET)
	public ResponseEntity<AirlineDTO> addAdmin(@PathVariable Long airline_id, @PathVariable Long admin_id) {
		Airline airline = airlineService.getOne(airline_id);
		if(airline != null) {
			airline.setAdmin_id(admin_id);
			
			airlineService.save(airline);
			return new ResponseEntity<AirlineDTO>(new AirlineDTO(airline), HttpStatus.OK);
		}
		return null;
	}

}
