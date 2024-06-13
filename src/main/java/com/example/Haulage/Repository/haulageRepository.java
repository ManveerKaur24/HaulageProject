package com.example.Haulage.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Haulage.Entity.Country;
import com.example.Haulage.Entity.Haulage;


	@Repository
	public interface haulageRepository extends JpaRepository<Haulage, Long> {

		@Query("FROM Country c WHERE c.countryName = :countryName")
		public Country existCountry(String countryName);

		@Query("from Haulage AS hl where hl.Sender_Name=:senderName")
		List<Haulage> findBySender_Name(String senderName);
		
		@Query("from Haulage AS hl where hl.Sender_MobileNo=:Clientmobile")
		List<Haulage> findByClient_mobile(String Clientmobile);
		
		@Query("from Haulage AS hl where hl.booking_date=:parsedDate")
		List<Haulage> findByBooking_date(LocalDate parsedDate);

		@Query("from Haulage AS hl where hl.trackingCode=:trackingCode")
		public List<Haulage> findAllByTrackingCode(String trackingCode);

		@Query("from Haulage AS hl where hl.CourierStatus=:status")
		public List<Haulage> findByStatus(String status);
		
		@Modifying
		@Transactional
	    @Query("UPDATE Haulage u SET u.CourierStatus ='Cancelled' where u.id=:id")	
	    public void updateCourierStatus(Long id);
		
		
}
