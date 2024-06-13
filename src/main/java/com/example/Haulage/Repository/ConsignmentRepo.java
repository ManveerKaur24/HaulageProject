package com.example.Haulage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Haulage.Entity.Consignment;

@Repository
public interface ConsignmentRepo extends JpaRepository<Consignment, Long>{

	
	
}
