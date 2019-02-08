package rs.ftn.isa.dto;

import rs.ftn.isa.model.Room;

public class RoomDTO {
	
	private Long id;
	
	private int beds;
	
	private float price;
	
	private double rating;
	
	private boolean onDiscount;

	public RoomDTO(Long id, int beds, float price, double rating, boolean onDiscount) {
		super();
		this.id = id;
		this.beds = beds;
		this.price = price;
		this.rating = rating;
		this.onDiscount = onDiscount;
	}
	
	public RoomDTO(Room r) {
		this(r.getId(), r.getBeds(), r.getPrice(), r.getRating(), r.isOnDiscount());
	}

	public RoomDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public boolean isOnDiscount() {
		return onDiscount;
	}

	public void setOnDiscount(boolean onDiscount) {
		this.onDiscount = onDiscount;
	}
	
	 

}
