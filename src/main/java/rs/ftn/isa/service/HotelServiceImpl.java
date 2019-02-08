package rs.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ftn.isa.model.Hotel;
import rs.ftn.isa.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel getOne(Long id) {
		return hotelRepository.getOne(id);
	}
	
	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}
	
	@Transactional
	@Override
	public Hotel save(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelRepository.save(hotel);
	}
	
	@Transactional
	@Override
	public Hotel update(Hotel oldHotel, Hotel newHotel) {
		// TODO Auto-generated method stub
		if(newHotel.getName() != null) {
			oldHotel.setName(newHotel.getName());
		}
		if(newHotel.getAddress() != null) {
			oldHotel.setAddress(newHotel.getAddress());
		}
		if(newHotel.getDescription() != null) {
			oldHotel.setDescription(newHotel.getDescription());
		}
		
		return hotelRepository.save(oldHotel);
	}

	
	
}
