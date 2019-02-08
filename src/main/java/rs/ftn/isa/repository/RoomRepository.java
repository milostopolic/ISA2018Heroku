package rs.ftn.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ftn.isa.model.AdditionalService;
import rs.ftn.isa.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

	List<Room> findByHotel_Id(Long id);
	
}
