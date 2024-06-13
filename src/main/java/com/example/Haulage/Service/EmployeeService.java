package com.example.Haulage.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Haulage.Entity.Employee;
import com.example.Haulage.Entity.LoginDetails;
import com.example.Haulage.Repository.EmployeeRepository;
import com.example.Haulage.Repository.LoginDetailsRepository;

@Service
public class EmployeeService {

@Autowired 
EmployeeRepository employeerepo;

@Autowired
LoginDetailsRepository registrationRepository;

public void saveEmployee(Employee employee) {
	 employeerepo.save(employee);	
	 
	 // 
	 LoginDetails reg= new LoginDetails();
	 reg.setEmailID(employee.getEmpemail());
	 reg.setUserName(employee.getEmpname());
	 reg.setPassword(employee.getEmpcontact());
	 registrationRepository.save(reg);
}


public List<Employee> getAll() {

	return employeerepo.findAll();
}


public Employee update(Long id) {
	return employeerepo.findById(id).get();
	
}


public void delete(Long id) {
	 employeerepo.deleteById(id);
}



}

