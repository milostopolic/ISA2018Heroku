package rs.ftn.isa.dto;

import java.util.Date;

import rs.ftn.isa.model.BookingFlight;

public class BookingFlightDTO {
	
	private Long id;

	private SeatDTO seats;
	
	private FlightDTO flight;
	
	private String email;
	
	private String reservationDate;
	
	private float passport_nmb;
	
	private String status;

	public BookingFlightDTO(Long id,SeatDTO seats, FlightDTO flight, String email, String reservationDate, float passport_nmb,
			String status) {
		super();
		this.id = id;
		this.seats = seats;
		this.flight = flight;
		this.email = email;
		this.reservationDate = reservationDate;
		this.passport_nmb = passport_nmb;
		this.status = status;
	}

	public BookingFlightDTO() {
		super();
	}

	public BookingFlightDTO(Long id, SeatDTO seats, FlightDTO flight, String email, String reservationDate, float passport_nmb) {
		super();
		this.id = id;
		this.seats = seats;
		this.flight = flight;
		this.email = email;
		this.reservationDate = reservationDate;
		this.passport_nmb = passport_nmb;
	}
	
	
	public BookingFlightDTO(BookingFlight bookingFlight) {
		this.id = bookingFlight.getId();
		this.seats = new SeatDTO(bookingFlight.getSeats());
		this.flight = new FlightDTO(bookingFlight.getFlight());
		if(bookingFlight.getUser() != null) {
			this.email = bookingFlight.getUser().getEmail();
		}
		
		this.passport_nmb = bookingFlight.getPassport_nmb();
		
		
	}

	public SeatDTO getSeats() {
		return seats;
	}

	public void setSeats(SeatDTO seat) {
		this.seats = seat;
	}

	public FlightDTO getFlight() {
		return flight;
	}

	public void setFlight(FlightDTO flight) {
		this.flight = flight;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
