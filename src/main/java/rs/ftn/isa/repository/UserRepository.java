package rs.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ftn.isa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	
}
