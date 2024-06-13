package com.example.Haulage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Haulage.Entity.Centre;

@Repository
public interface CentreRepository extends JpaRepository<Centre, Long>{

}
