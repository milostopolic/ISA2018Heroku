package rs.ftn.isa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Version
	private int version;
	
	@Column(nullable = false)	
	private String name;
	
	@Column(nullable = false)	
	private String address;
	
	@Column(nullable = false)	
	private String description;
	
	@Column(nullable = false)	
	private String image;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "hotel")
	private List<Room> rooms;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "hotel")
	private Pricelist pricelist;
	
	@OneToMany(mappedBy = "hotel")
	private List<Booking> bookings;
	
	@Column
	private Long admin_id;
	
	private double rating;

	public Hotel(Long id, String name, String address, String description, String image, Pricelist pricelist, Long admin_id, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.image = image;
		this.pricelist = pricelist;
		this.admin_id = admin_id;
		this.rating = rating;
	}

	public Hotel() {
		super();
		//this.rooms = new ArrayList<>();
		//this.pricelist = new Pricelist();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Pricelist getPricelist() {
		return pricelist;
	}

	public void setPricelist(Pricelist pricelist) {
		this.pricelist = pricelist;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
}
