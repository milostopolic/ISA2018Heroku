package rs.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ftn.isa.model.Seat;
import rs.ftn.isa.repository.SeatRepository;

@Service
public class SeatServiceImlp implements SeatService{
	
	@Autowired
	private SeatRepository seatRepository;

	@Override
	public Seat getOne(Long id) {
		// TODO Auto-generated method stub
		return seatRepository.getOne(id);
	}

	@Override
	public List<Seat> getAll() {
		// TODO Auto-generated method stub
		return seatRepository.findAll();
	}

	@Transactional
	@Override
	public Seat save(Seat seat) {
		// TODO Auto-generated method stub
		return seatRepository.save(seat);
	}
	
	
}
