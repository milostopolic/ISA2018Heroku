package rs.ftn.isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ftn.isa.model.Destination;
import rs.ftn.isa.repository.DestinationRepository;

@Service
public class DestinationServiceImpl implements DestinationService {

	@Autowired
	private DestinationRepository destinationRepository;

	@Transactional
	@Override
	public Destination save(Destination destination) {		
		// TODO Auto-generated method stub
		return destinationRepository.save(destination);

	}

	@Transactional
	@Override
	public void delete(Destination destination) {
		// TODO Auto-generated method stub
		 destinationRepository.delete(destination);
	}

	@Override
	public Destination getOne(Long id) {
		// TODO Auto-generated method stub
		return destinationRepository.getOne(id);
	}

	@Transactional
	@Override
	public Destination update(Destination oldDestination, Destination newDestination) {
		// TODO Auto-generated method stub
		if(newDestination.getName() != null){
			oldDestination.setName(newDestination.getName());
		}
		
		
		return destinationRepository.save(oldDestination);
	}
	
	
	
}
