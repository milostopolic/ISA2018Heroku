package rs.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ftn.isa.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

}
