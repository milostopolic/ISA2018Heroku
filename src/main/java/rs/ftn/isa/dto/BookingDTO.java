package rs.ftn.isa.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rs.ftn.isa.model.AdditionalService;
import rs.ftn.isa.model.Booking;
import rs.ftn.isa.model.Room;

public class BookingDTO {
	
	private Long id;
	
	private List<RoomDTO> rooms = new ArrayList<>();
	
	private List<AdditionalServiceDTO> additionalServices = new ArrayList<>();
	
	private Date sDate;
	
	private Date eDate;
	
	private String email;
	
	private Long hotel_id;
	
	private float totalPrice;
	
	public BookingDTO(List<Room> roomsDTO, Long id) {
		for(Room r : roomsDTO) {
			this.rooms.add(new RoomDTO(r));
		}
		this.id = id;
	}

	public BookingDTO(List<RoomDTO> roomsDTO, List<AdditionalServiceDTO> additionalServicesDTO, Date sDate,
			Date eDate, Long hotel_id, float totalPrice, Long id) {
		super();
		this.rooms = roomsDTO;
		this.additionalServices = additionalServicesDTO;
		this.sDate = sDate;
		this.eDate = eDate;
		this.hotel_id = hotel_id;
		this.totalPrice = totalPrice;
		this.id = id;
	}
	
	public BookingDTO(Booking booking) {
		//List<RoomDTO> roomsDTO = new ArrayList<>();
		for(Room r : booking.getRooms()) {
			this.rooms.add(new RoomDTO(r));
		}
		
		//List<AdditionalServiceDTO> additionalServicesDTO = new ArrayList<>();
		for(AdditionalService as : booking.getAdditionalServices()) {
			this.additionalServices.add(new AdditionalServiceDTO(as));
		}
		
		//this.roomsDTO = roomsDTO;
		//this.additionalServicesDTO = additionalServicesDTO;
		this.sDate = booking.getStartDate();
		this.eDate = booking.getEndDate();
		this.hotel_id = booking.getHotel().getId();
		this.totalPrice = booking.getTotalPrice();
		this.id = booking.getId();
	}

	public BookingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<RoomDTO> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomDTO> roomsDTO) {
		this.rooms = roomsDTO;
	}

	public List<AdditionalServiceDTO> getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(List<AdditionalServiceDTO> additionalServicesDTO) {
		this.additionalServices = additionalServicesDTO;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(Long hotel_id) {
		this.hotel_id = hotel_id;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
