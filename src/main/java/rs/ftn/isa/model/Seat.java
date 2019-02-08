package rs.ftn.isa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Seat {
	
	//id bool zauzeto  red i kolona
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Version
	private int version;
	
	@Column
	private boolean reserved;
	
	@Column
	private int roww;
	
	@Column
	private String columnn;
	
	@OneToOne
	private Flight flight;

	public Seat() {
		super();
	}

	public Seat(Long id, boolean zauzeto, int red, String kolona, Flight flight) {
		super();
		this.id = id;
		this.reserved = zauzeto;
		this.roww = red;
		this.columnn = kolona;
		this.flight = flight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean zauzeto) {
		this.reserved = zauzeto;
	}

	public int getRow() {
		return roww;
	}

	public void setRow(int red) {
		this.roww = red;
	}

	public String getColumn() {
		return columnn;
	}

	public void setColumn(String kolona) {
		this.columnn = kolona;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
	
	

}
