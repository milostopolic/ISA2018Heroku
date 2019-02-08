package rs.ftn.isa.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Version
	private int version;
	
	@ManyToOne
	private User user;
	
	@Column
	private float totalPrice = 0;
	
	@ManyToOne
	private Hotel hotel;
	
	@ManyToMany
	@JoinTable(
	        name = "booking_additional_services", 
	        joinColumns = { @JoinColumn(name = "booking_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "additional_services_id") }
	    )
	private List<AdditionalService> additionalServices = new ArrayList<>();
	
	@ElementCollection
	private List<Room> rooms = new ArrayList<>();	
	
	@Temporal(value = TemporalType.DATE)
	private Date startDate;
	
	@Temporal(value = TemporalType.DATE)
	private Date endDate;

	public Booking(Long id, User user, float totalPrice, Hotel hotel, List<AdditionalService> additionalServices,
			List<Room> rooms, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.user = user;
		this.totalPrice = totalPrice;
		this.hotel = hotel;
		this.additionalServices = additionalServices;
		this.rooms = rooms;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<AdditionalService> getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(List<AdditionalService> additionalServices) {
		this.additionalServices = additionalServices;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	

}
