package com.example.Haulage.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Haulage.Entity.Centre;
import com.example.Haulage.Repository.CentreRepository;

import jakarta.validation.Valid;

@Service
public class CentreService {
	@Autowired
	CentreRepository cRepository;

	public List<Centre> getAll() {
		return cRepository.findAll();
	}
	
	public void saveDetails(@Valid Centre centre) {
		cRepository.save(centre);
	}
	
	public Centre update(Long id) {
		return cRepository.findById(id).get();
		
	}

	public Centre getById(Long id) {
		return cRepository.findById(id).get();
	}
}
