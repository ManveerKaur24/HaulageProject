package com.example.Haulage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Haulage.Entity.*;

@Repository
public interface CountryRepository extends JpaRepository<com.example.Haulage.Entity.Country, Long> {

	@Query("FROM Country c WHERE c.countryName = :countryName")
	public Country existCountry(String countryName);

}
