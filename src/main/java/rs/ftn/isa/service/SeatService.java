package rs.ftn.isa.service;

import java.util.List;


import rs.ftn.isa.model.Seat;

public interface SeatService {

	Seat getOne(Long id);
	List<Seat> getAll();
	Seat save(Seat seat);
	
}
