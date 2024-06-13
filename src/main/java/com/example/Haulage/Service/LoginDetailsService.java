package com.example.Haulage.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Haulage.Entity.LoginDetails;
import com.example.Haulage.Repository.LoginDetailsRepository;

@Service
public class LoginDetailsService {

	@Autowired
	LoginDetailsRepository loginDetailsRepository;
	
	public LoginDetails checkUserNamePassword(String user, String pass) {
		
		List<LoginDetails> list= loginDetailsRepository.checkUserNamePassword(user, pass);
		
		return list.size()>0?list.get(0):null;
	}
	
	public void addLoginDetails(LoginDetails loginDetails) {
		
		loginDetailsRepository.save(loginDetails);
	}
}
