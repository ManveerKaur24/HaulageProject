package com.example.Haulage.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Haulage.Entity.HaulageService;
import com.example.Haulage.Repository.ServiceHaulageRepository;
import jakarta.validation.Valid;

@Service
public class ServiceHaulageService {

	@Autowired
	ServiceHaulageRepository SRepository;

	public List<HaulageService> getAll() {
		return SRepository.findAll();

	}

	public void saveDetails(@Valid HaulageService haulage) {
		SRepository.save(haulage);
	}
	
	public HaulageService update(Long id) {
		return SRepository.findById(id).orElse(null);
		
	}

	public HaulageService getById(Long id) {
		return SRepository.findById(id).get();
	}

}
