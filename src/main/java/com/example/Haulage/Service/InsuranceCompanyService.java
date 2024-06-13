package com.example.Haulage.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Haulage.Entity.InsuranceCompany;
import com.example.Haulage.Repository.InsuranceCompanyRepository;



@Service
public class InsuranceCompanyService {

	@Autowired
   InsuranceCompanyRepository  insurenceRepo;


   public List<InsuranceCompany>getAll(){
	  return insurenceRepo.findAll();
   }

   public void saveInsurance(InsuranceCompany ic) {
	   
	   insurenceRepo.save(ic);
  }

public InsuranceCompany update(Long id) {
	return insurenceRepo.findById(id).get();
	
}


public void delete(Long id) {
	 insurenceRepo.deleteById(id);
}


}
