package com.example.Haulage.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HaulageService {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String Service;
	private int Min_days;
	private int Max_days;
	private double Charges;
	private String Description;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getService() {
		return Service;
	}
	public void setService(String service) {
		Service = service;
	}
	public int getMin_days() {
		return Min_days;
	}
	public void setMin_days(int min_days) {
		Min_days = min_days;
	}
	public int getMax_days() {
		return Max_days;
	}
	public void setMax_days(int max_days) {
		Max_days = max_days;
	}
	public double getCharges() {
		return Charges;
	}
	public void setCharges(double charges) {
		Charges = charges;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

	
	

}
