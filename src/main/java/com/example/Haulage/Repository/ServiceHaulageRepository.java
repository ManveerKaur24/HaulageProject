package com.example.Haulage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Haulage.Entity.HaulageService;

@Repository
public interface ServiceHaulageRepository extends JpaRepository<HaulageService, Long> {

}
