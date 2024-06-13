package com.example.Haulage.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Haulage.Entity.*;
@Repository
public interface StateRepository extends JpaRepository<State, Long>{

	List<State> getStateByCountryId(Long id);
}
