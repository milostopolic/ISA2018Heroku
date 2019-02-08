package rs.ftn.isa.dto;

import rs.ftn.isa.model.Flight;
import rs.ftn.isa.model.Seat;

public class SeatDTO {
	
	private Long id;
	
	private int roww;
	
	private String columnn;
	
	private boolean reserved;
	
	private FlightDTO flight;

	public SeatDTO() {
		super();
	}

	public SeatDTO(Long id, int roww, String columnn, boolean reserved) {
		super();
		this.id = id;
		this.roww = roww;
		this.columnn = columnn;
		this.reserved = reserved;
	}
	
	public SeatDTO(Seat s) {
		this(s.getId(), s.getRow(), s.getColumn(), s.isReserved());
		this.flight = new FlightDTO(s.getFlight());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRoww() {
		return roww;
	}

	public void setRoww(int roww) {
		this.roww = roww;
	}

	public String getColumnn() {
		return columnn;
	}

	public void setColumnn(String columnn) {
		this.columnn = columnn;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	
	public void setFlight(FlightDTO flight) {
		this.flight = flight;
	}

	public FlightDTO getFlight() {
		return flight;
	}
	
	

}
