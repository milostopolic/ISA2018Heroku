package rs.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ftn.isa.model.Room;
import rs.ftn.isa.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public Room getOne(Long id) {
		// TODO Auto-generated method stub
		return roomRepository.getOne(id);
	}	
	
	@Transactional
	@Override
	public Room save(Room room) {
		// TODO Auto-generated method stub
		return roomRepository.save(room);
	}
	
	@Transactional
	@Override
	public void delete(Room room) {
		// TODO Auto-generated method stub
		roomRepository.delete(room);
	}

	@Override
	public List<Room> findByHotel_Id(Long id) {
		return roomRepository.findByHotel_Id(id);
	}

}
