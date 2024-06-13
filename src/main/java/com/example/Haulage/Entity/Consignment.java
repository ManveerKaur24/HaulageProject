package com.example.Haulage.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Consignment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ConsignmentType;
	private String discription;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConsignmentType() {
		return ConsignmentType;
	}
	public void setConsignmentType(String consignmentType) {
		ConsignmentType = consignmentType;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	
}
