package com.example.Haulage.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class InsuranceCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String insuranceCompanyName;
	private String contactPerson;
	private String contactNumber;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String pincode;

	@ManyToOne
	@JoinColumn(name = "insurance_district_id")
	District InsuranceDistrict;

	
	
	public District getInsuranceDistrict() {
		return InsuranceDistrict;
	}

	public void setInsuranceDistrict(District insuranceDistrict) {
		InsuranceDistrict = insuranceDistrict;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInsuranceCompanyName() {
		return insuranceCompanyName;
	}

	public void setInsuranceCompanyName(String insuranceCompanyName) {
		this.insuranceCompanyName = insuranceCompanyName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

//	public InsuranceCompany(Long id, String insuranceCompanyName, String contactPerson, String contactNunber, String addressLine1, String addressLine2, String country, String state, String district, String city, String pincode) {
//		
//		this.id = id;
//		this.insuranceCompanyName=insuranceCompanyName;
//		this.contactPerson=contactPerson;
//		this.contactNumber=contactNunber;
//		this.addressLine1=addressLine1;
//		this.addressLine2=addressLine2;
//		
//		this.city=city;
//		this.pincode=pincode;
//	}

}