package com.example.Haulage.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class HaulageCustomer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String Mobile_no;
	private String email_id;

	private String Address_line1;
	private String Address_line2;
	private String City;
	private String Pin_code;

	@ManyToOne
	@JoinColumn(name="district_id")
	District district;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile_no() {
		return Mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		Mobile_no = mobile_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getAddress_line1() {
		return Address_line1;
	}

	public void setAddress_line1(String address_line1) {
		Address_line1 = address_line1;
	}

	public String getAddress_line2() {
		return Address_line2;
	}

	public void setAddress_line2(String address_line2) {
		Address_line2 = address_line2;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getPin_code() {
		return Pin_code;
	}

	public void setPin_code(String pin_code) {
		Pin_code = pin_code;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
}
