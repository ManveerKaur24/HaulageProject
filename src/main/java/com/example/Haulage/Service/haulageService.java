package com.example.Haulage.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Haulage.Entity.*;
import com.example.Haulage.Repository.*;

@Service
public class haulageService {
	@Autowired
	haulageRepository haulageRepository;

	private static final String ALPHANUMERIC_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	public List<Haulage> getAll() {

		return haulageRepository.findAll();
	}

	public void saveDetails(Haulage haulage) {
		haulage.setTrackingCode(generateRandomString());
		haulage.setCourierStatus("Booked");

		haulageRepository.save(haulage);
	}

	public Haulage getOneObject(Long id) {
		Optional<Haulage> optional = haulageRepository.findById(id);
		return optional.get();
	}

	public void delete(Long id) {
		Haulage hl = getOneObject(id);
		haulageRepository.delete(hl);

	}

	public List<Haulage> getByBookingDate(LocalDate parsedDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Haulage> findByName(String rname) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Haulage> getByClientName(String clientName) {
		return haulageRepository.findBySender_Name(clientName);
	}

	public List<Haulage> getByClient_mobile(String Clientmobile) {
		return haulageRepository.findByClient_mobile(Clientmobile);
	}

	public List<Haulage> getByBooking_date(LocalDate parsedDate) {
		return haulageRepository.findByBooking_date(parsedDate);
	}

	public static String generateRandomString() {
		StringBuilder randomString = new StringBuilder();
		Random random = new Random();
		int length = 10;
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(ALPHANUMERIC_CHARS.length());
			char randomChar = ALPHANUMERIC_CHARS.charAt(index);
			randomString.append(randomChar);
		}
		return randomString.toString();
	}

	public List<Haulage> getByTrackingCode(String trackingCode) {
		return haulageRepository.findAllByTrackingCode(trackingCode);
	}

	public List<Haulage> getByStatus(String status) {
		return haulageRepository.findByStatus(status);
	}

	public Haulage getById(Long id) {
		return haulageRepository.findById(id).get();
	}
	public void updateCourierStatus(Long id) {
		haulageRepository.updateCourierStatus(id);
	}
	
}
