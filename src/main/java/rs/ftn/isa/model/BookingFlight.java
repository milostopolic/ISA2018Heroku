package rs.ftn.isa.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


@Entity
public class BookingFlight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Version
	private int version;
	
	@ManyToOne
	private User user;
	
	@OneToOne
	private Seat seats;
	
	@Column
	private float totalPrice;
	
	@ManyToOne
	private Flight flight;
	
	@Temporal(TemporalType.DATE)
	private Date reservationDate;
	
	@Column
	private float passport_nmb;
	
	@Column
	private String status;
	
	
		
	public BookingFlight() {
		super();
	}

	
	public BookingFlight(Long id, User user, Seat seats, float totalPrice, Flight flight, Date reservationDate,
			float passport_nmb, String status) {
		super();
		this.id = id;
		this.user = user;
		this.seats = seats;
		this.totalPrice = totalPrice;
		this.flight = flight;
		this.reservationDate = reservationDate;
		this.passport_nmb = passport_nmb;
		this.status = status;
	}


	public BookingFlight(Long id, User user, Seat seats, float totalPrice, Flight flight, Date reservationDate,
			float passport_nmb) {
		super();
		this.id = id;
		this.user = user;
		this.seats = seats;
		this.totalPrice = totalPrice;
		this.flight = flight;
		this.reservationDate = reservationDate;
		this.passport_nmb = passport_nmb;
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


	public Seat getSeats() {
		return seats;
	}


	public void setSeats(Seat seats) {
		this.seats = seats;
	}


	public float getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Flight getFlight() {
		return flight;
	}


	public void setFlight(Flight flight) {
		this.flight = flight;
	}


	public Date getReservationDate() {
		return reservationDate;
	}


	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}


	public float getPassport_nmb() {
		return passport_nmb;
	}


	public void setPassport_nmb(float passport_nmb) {
		this.passport_nmb = passport_nmb;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	

	

	
	
	
	
}
