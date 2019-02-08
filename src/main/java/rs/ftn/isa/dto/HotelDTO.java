package rs.ftn.isa.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;

import rs.ftn.isa.model.Hotel;
import rs.ftn.isa.model.Room;

public class HotelDTO {
	
	private Long id;
	
	private String name;
	
	private String address;
	
	private String description;
	
	private String image;
	
	private List<RoomDTO> roomsDTO;
	
	private PricelistDTO pricelistDTO;
	
	private Long admin_id;
	
	private double rating;

	
	
	public HotelDTO(Long id, String name, String address, String description, String image, List<RoomDTO> roomsDTO, PricelistDTO pricelistDTO, Long admin_id, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.image = image;
		this.roomsDTO = roomsDTO;
		this.pricelistDTO = pricelistDTO;
		this.admin_id = admin_id;
		this.rating = rating;
	}

	public HotelDTO(Hotel hotel) {
		List<RoomDTO> roomsDTO = new ArrayList<>();
		//Hibernate.initialize(hotel.getRooms());
		for(Room r : hotel.getRooms()) {
			roomsDTO.add(new RoomDTO(r));
		}
		this.id = hotel.getId();
		this.name = hotel.getName();
		this.address = hotel.getAddress();
		this.description = hotel.getDescription();
		this.image = hotel.getImage();
		this.roomsDTO = roomsDTO;
		this.admin_id = hotel.getAdmin_id();
		this.rating = hotel.getRating();
		
		if(hotel.getPricelist() != null) {
			System.out.println("USAO JE U IF ZA PRICELIST");
			this.pricelistDTO = new PricelistDTO(hotel.getPricelist());
		}
	}

	public HotelDTO() {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<RoomDTO> getRoomsDTO() {
		return roomsDTO;
	}

	public void setRoomsDTO(List<RoomDTO> roomsDTO) {
		this.roomsDTO = roomsDTO;
	}

	public PricelistDTO getPricelistDTO() {
		return pricelistDTO;
	}

	public void setPricelistDTO(PricelistDTO pricelistDTO) {
		this.pricelistDTO = pricelistDTO;
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
