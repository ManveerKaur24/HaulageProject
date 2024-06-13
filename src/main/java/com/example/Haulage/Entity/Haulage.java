package com.example.Haulage.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Haulage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String Booking_code;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private LocalDate booking_date;
	
	private String weight_unit;
	private String volume_unit;
	private String length_unit;
	private String distance_unit;
	private String haulage_mode;
	private String eWay_billNo;
	

	private String hazardous;
	private String explaination;
	private String consignment_type;

	private Integer no_of_Pieces;
	private String haulage_centre;
	private String description;
	private Double distance;
	private Double total_weight;
//	private String haulage_service;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private LocalDate expected_DeliveryDate;
	
	private Double charges;
	private Double final_charges;
	private String Tax_type;
	private Double Tax_Percentage;
	private String Discount_type;
	private Double discount_in_amount;
	private Double discount_in_per;
	
	@OneToMany(mappedBy = "haulage", cascade = CascadeType.ALL, targetEntity = HaulageItems.class)
	List<HaulageItems> HaulageItem = new ArrayList<HaulageItems>();
//	
//	@OneToMany(mappedBy = "Service", cascade = CascadeType.ALL, targetEntity = HaulageService.class)
//	List<HaulageService> HSLsit = new ArrayList<HaulageService>();
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	HaulageCustomer customer;
	
	
	//Sender's info 
	private String Sender_Name;
	private String Sender_MobileNo;
	private String Sender_EmailId;
	private String Sender_AddressLne1;
	private String Sender_AddressLine2;
	private String Sender_City;
	private String Sender_Pincode;
	@ManyToOne
    @JoinColumn(name = "sender_district_id")
	District sender_District;
	
	//Reciever's info
	private String reciever_Name;
	private String reciever_MobileNo;
	private String reciever_EmailId;
	private String reciever_AddressLne1;
	private String reciever_AddressLine2;
	private String reciever_City;
	private String reciever_Pincode;
	
    @ManyToOne
    @JoinColumn(name = "receiver_district_id")
	District reciever_District;

    @ManyToOne
    @JoinColumn(name = "Haulage_Service_id")
	HaulageService haulageService;
    
	private String trackingCode;
	private String CourierStatus;

	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	public String getCourierStatus() {
		return CourierStatus;
	}

	public void setCourierStatus(String courierStatus) {
		CourierStatus = courierStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBooking_code() {
		return Booking_code;
	}

	public void setBooking_code(String booking_code) {
		Booking_code = booking_code;
	}

	public LocalDate getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(LocalDate booking_date) {
		this.booking_date = booking_date;
	}

	public String getWeight_unit() {
		return weight_unit;
	}

	public void setWeight_unit(String weight_unit) {
		this.weight_unit = weight_unit;
	}

	public String getVolume_unit() {
		return volume_unit;
	}

	public void setVolume_unit(String volume_unit) {
		this.volume_unit = volume_unit;
	}

	public String getLength_unit() {
		return length_unit;
	}

	public void setLength_unit(String length_unit) {
		this.length_unit = length_unit;
	}

	public String getDistance_unit() {
		return distance_unit;
	}

	public void setDistance_unit(String distance_unit) {
		this.distance_unit = distance_unit;
	}

	public String geteWay_billNo() {
		return eWay_billNo;
	}

	public void seteWay_billNo(String eWay_billNo) {
		this.eWay_billNo = eWay_billNo;
	}

	public String getHazardous() {
		return hazardous;
	}

	public void setHazardous(String hazardous) {
		this.hazardous = hazardous;
	}

	public String getExplaination() {
		return explaination;
	}

	public void setExplaination(String explaination) {
		this.explaination = explaination;
	}

	public String getConsignment_type() {
		return consignment_type;
	}

	public void setConsignment_type(String consignment_type) {
		this.consignment_type = consignment_type;
	}

	public Integer getNo_of_Pieces() {
		return no_of_Pieces;
	}

	public void setNo_of_Pieces(Integer no_of_Pieces) {
		this.no_of_Pieces = no_of_Pieces;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getTotal_weight() {
		return total_weight;
	}

	public void setTotal_weight(Double total_weight) {
		this.total_weight = total_weight;
	}

	public LocalDate getExpected_DeliveryDate() {
		return expected_DeliveryDate;
	}

	public void setExpected_DeliveryDate(LocalDate expected_DeliveryDate) {
		this.expected_DeliveryDate = expected_DeliveryDate;
	}

	public Double getCharges() {
		return charges;
	}

	public void setCharges(Double charges) {
		this.charges = charges;
	}

	public Double getFinal_charges() {
		return final_charges;
	}

	public void setFinal_charges(Double final_charges) {
		this.final_charges = final_charges;
	}

	public String getTax_type() {
		return Tax_type;
	}

	public void setTax_type(String tax_type) {
		Tax_type = tax_type;
	}

	public Double getTax_Percentage() {
		return Tax_Percentage;
	}

	public void setTax_Percentage(Double tax_Percentage) {
		Tax_Percentage = tax_Percentage;
	}

	public String getDiscount_type() {
		return Discount_type;
	}

	public void setDiscount_type(String discount_type) {
		Discount_type = discount_type;
	}

	public Double getDiscount_in_amount() {
		return discount_in_amount;
	}

	public void setDiscount_in_amount(Double discount_in_amount) {
		this.discount_in_amount = discount_in_amount;
	}

	public Double getDiscount_in_per() {
		return discount_in_per;
	}

	public void setDiscount_in_per(Double discount_in_per) {
		this.discount_in_per = discount_in_per;
	}

	public List<HaulageItems> getHaulageItem() {
		return HaulageItem;
	}

	public void setHaulageItem(List<HaulageItems> haulageItem) {
		HaulageItem = haulageItem;
	}

	public HaulageCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(HaulageCustomer customer) {
		this.customer = customer;
	}

	public String getSender_Name() {
		return Sender_Name;
	}

	public void setSender_Name(String sender_Name) {
		Sender_Name = sender_Name;
	}

	public String getSender_MobileNo() {
		return Sender_MobileNo;
	}

	public void setSender_MobileNo(String sender_MobileNo) {
		Sender_MobileNo = sender_MobileNo;
	}

	public String getSender_EmailId() {
		return Sender_EmailId;
	}

	public void setSender_EmailId(String sender_EmailId) {
		Sender_EmailId = sender_EmailId;
	}

	public String getSender_AddressLne1() {
		return Sender_AddressLne1;
	}

	public void setSender_AddressLne1(String sender_AddressLne1) {
		Sender_AddressLne1 = sender_AddressLne1;
	}

	public String getSender_AddressLine2() {
		return Sender_AddressLine2;
	}

	public void setSender_AddressLine2(String sender_AddressLine2) {
		Sender_AddressLine2 = sender_AddressLine2;
	}

	public String getSender_City() {
		return Sender_City;
	}

	public void setSender_City(String sender_City) {
		Sender_City = sender_City;
	}

	public String getSender_Pincode() {
		return Sender_Pincode;
	}

	public void setSender_Pincode(String sender_Pincode) {
		Sender_Pincode = sender_Pincode;
	}

	public District getSender_District() {
		return sender_District;
	}

	public void setSender_District(District sender_District) {
		this.sender_District = sender_District;
	}

	public String getReciever_Name() {
		return reciever_Name;
	}

	public void setReciever_Name(String reciever_Name) {
		this.reciever_Name = reciever_Name;
	}

	public String getReciever_MobileNo() {
		return reciever_MobileNo;
	}

	public void setReciever_MobileNo(String reciever_MobileNo) {
		this.reciever_MobileNo = reciever_MobileNo;
	}

	public String getReciever_EmailId() {
		return reciever_EmailId;
	}

	public void setReciever_EmailId(String reciever_EmailId) {
		this.reciever_EmailId = reciever_EmailId;
	}

	public String getReciever_AddressLne1() {
		return reciever_AddressLne1;
	}

	public void setReciever_AddressLne1(String reciever_AddressLne1) {
		this.reciever_AddressLne1 = reciever_AddressLne1;
	}

	public String getReciever_AddressLine2() {
		return reciever_AddressLine2;
	}

	public void setReciever_AddressLine2(String reciever_AddressLine2) {
		this.reciever_AddressLine2 = reciever_AddressLine2;
	}

	public String getReciever_City() {
		return reciever_City;
	}

	public void setReciever_City(String reciever_City) {
		this.reciever_City = reciever_City;
	}

	public String getReciever_Pincode() {
		return reciever_Pincode;
	}

	public void setReciever_Pincode(String reciever_Pincode) {
		this.reciever_Pincode = reciever_Pincode;
	}

	public District getReciever_District() {
		return reciever_District;
	}

	public void setReciever_District(District reciever_District) {
		this.reciever_District = reciever_District;
	}
	
	public String getHaulage_mode() {
		return haulage_mode;
	}

	public void setHaulage_mode(String haulage_mode) {
		this.haulage_mode = haulage_mode;
	}
	public String getHaulage_centre() {
		return haulage_centre;
	}

	public void setHaulage_centre(String haulage_centre) {
		this.haulage_centre = haulage_centre;
	}

	public HaulageService getHaulageService() {
		return haulageService;
	}

	public void setHaulageService(HaulageService haulageService) {
		this.haulageService = haulageService;
	}

	

	
}
