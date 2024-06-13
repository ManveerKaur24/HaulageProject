package com.example.Haulage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Haulage.Entity.*;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {



}
