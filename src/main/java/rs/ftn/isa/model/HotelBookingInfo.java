package rs.ftn.isa.model;

import java.util.Date;

public class HotelBookingInfo {
	
	private int rooms;
	
	private int persons;
	
	private Date sDate;
	
	private Date eDate;

	public HotelBookingInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelBookingInfo(int rooms, int persons, Date sDate, Date eDate) {
		super();
		this.rooms = rooms;
		this.persons = persons;
		this.sDate = sDate;
		this.eDate = eDate;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public int getPersons() {
		return persons;
	}

	public void setPersons(int persons) {
		this.persons = persons;
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
	
	

}
