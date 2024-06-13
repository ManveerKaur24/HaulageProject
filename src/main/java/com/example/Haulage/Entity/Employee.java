package com.example.Haulage.Entity;


import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;

		private String empname;

		private String empemail;

		private String empdesignation;

		private String empcontact;
		
		private String empAddressLine1;
		
		private String empAddressLine2;
		
		private String city;
		
		private String Pincode;
		
		@DateTimeFormat(pattern= "yyyy-MM-dd")
		private String empdob;
		
		
		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getEmpname() {
			return empname;
		}


		public void setEmpname(String empname) {
			this.empname = empname;
		}


		public String getEmpemail() {
			return empemail;
		}


		public void setEmpemail(String empemail) {
			this.empemail = empemail;
		}


		public String getEmpdesignation() {
			return empdesignation;
		}


		public void setEmpdesignation(String empdesignation) {
			this.empdesignation = empdesignation;
		}


		public String getEmpcontact() {
			return empcontact;
		}


		public void setEmpcontact(String empcontact) {
			this.empcontact = empcontact;
		}


		public String getEmpAddressLine1() {
			return empAddressLine1;
		}


		public void setEmpAddressLine1(String empAddressLine1) {
			this.empAddressLine1 = empAddressLine1;
		}


		public String getEmpAddressLine2() {
			return empAddressLine2;
		}


		public void setEmpAddressLine2(String empAddressLine2) {
			this.empAddressLine2 = empAddressLine2;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getPincode() {
			return Pincode;
		}


		public void setPincode(String pincode) {
			Pincode = pincode;
		}


		public String getEmpdob() {
			return empdob;
		}


		public void setEmpdob(String empdob) {
			this.empdob = empdob;
		}


		public District getEmployee_District() {
			return employee_District;
		}


		public void setEmployee_District(District employee_District) {
			this.employee_District = employee_District;
		}


		@ManyToOne
	    @JoinColumn(name = "employeeDistrict_id")
		District employee_District;

	

		
	}

