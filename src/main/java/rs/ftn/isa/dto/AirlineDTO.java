package rs.ftn.isa.dto;

import java.util.ArrayList;
import java.util.List;

import rs.ftn.isa.model.Airline;
import rs.ftn.isa.model.Destination;
import rs.ftn.isa.model.Flight;

public class AirlineDTO {
	
	private Long id;
	
	private String name;
	
	private String address;
	
	private String description;
	
	private List<DestinationDTO> destinations;
	
	private List<FlightDTO> flightsDTO;	
	
	private String image;
	
	private Long admin_id;
	
	private double rating;
	
	public AirlineDTO(Long id, String name, String address, String description, List<DestinationDTO> destinations,
			List<FlightDTO> flightsDTO, String image, Long admin_id, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.destinations = destinations;
		this.flightsDTO = flightsDTO;
		this.image = image;
		this.admin_id = admin_id;
		this.rating = rating;
	}

	public AirlineDTO(Airline airline) {
		List<FlightDTO> flightsDTO = new ArrayList<>();
		List<DestinationDTO> destinations = new ArrayList<>();
		for(Destination d : airline.getDestinations()) {
			destinations.add(new DestinationDTO(d));
			
		}
		System.out.println("prvi");
		for(Flight f : airline.getFlights()) {
			flightsDTO.add(new FlightDTO(f));
		}
		System.out.println("drugi");
		this.id = airline.getId();
		this.name = airline.getName();
		this.address = airline.getAddress();
		this.description = airline.getDescription();
		this.destinations = destinations;
		this.flightsDTO = flightsDTO;
		this.image = airline.getImage();
		this.admin_id = airline.getAdmin_id();
		this.rating = airline.getRating();
	}

	public AirlineDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DestinationDTO> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<DestinationDTO> destinations) {
		this.destinations = destinations;
	}

	public List<FlightDTO> getFlightsDTO() {
		return flightsDTO;
	}

	public void setFlightsDTO(List<FlightDTO> flightsDTO) {
		this.flightsDTO = flightsDTO;
	}

	public Long getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	

}
