package com.example.Haulage.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Haulage.Entity.*;
import com.example.Haulage.Repository.*;

@Service
public class DistrictService {

	@Autowired
	private DistrictRepository districtRepository;

	public List<District> getAll() {

		return districtRepository.findAll();
	}

	public void saveDistrict(District district) {

		districtRepository.save(district);

	}

	public District update(Long id) {

		return districtRepository.findById(id).get();
	}

	public void delete(Long id) {

		districtRepository.deleteById(id);
	}

	public List<District> getDistrictByStateId(Long id) {

		return districtRepository.getDistrictByStateId(id);
	}

}
