package rs.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ftn.isa.model.AdditionalService;
import rs.ftn.isa.repository.AdditionalServiceRepository;
@Service
public class AdditionalServiceServiceImpl implements AdditionalServiceService {

	@Autowired
	private AdditionalServiceRepository additionalServiceRepository;
	
	@Override
	public AdditionalService getOne(Long id) {
		return additionalServiceRepository.getOne(id);
	}

	@Override
	public List<AdditionalService> getAll() {
		return additionalServiceRepository.findAll();
	}

	@Override
	public List<AdditionalService> findByPricelist_Id(Long id) {
		return additionalServiceRepository.findByPricelist_Id(id);
	}
	
	@Transactional
	@Override
	public AdditionalService save(AdditionalService additionalService) {
		return additionalServiceRepository.save(additionalService);
	}

	@Transactional
	@Override
	public void delete(AdditionalService additionalService) {
		additionalServiceRepository.delete(additionalService);		
	}
	
	@Transactional
	@Override
	public List<AdditionalService> saveAll(List<AdditionalService> additionalServices) {
		return additionalServiceRepository.saveAll(additionalServices);
	}

}
