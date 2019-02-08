package rs.ftn.isa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rs.ftn.isa.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	@Modifying
	//@Query(value = "select b from booking b where hotel_id = ?1 and ((start_date between ?2 and ?3) or (end_date between ?2 and ?3))",nativeQuery = true)
	@Query(value = "select * from booking b where b.hotel_id = ?1 and ((b.start_date between ?2 and ?3) or (b.end_date between ?2 and ?3))",nativeQuery = true)
	//@Query(value = "select b from booking b where b.hotel_id = ?1",nativeQuery = true)
	List<Booking> findBookingsInInterval(Long id, Date startDate, Date endDate);
	
	@Modifying	
	@Query(value = "select * from booking b where b.hotel_id = ?1 and b.user_id is null",nativeQuery = true)
	List<Booking> findByHotelAndUserIsNull(Long id);
	
	List<Booking> findByHotel(Long id);

}
