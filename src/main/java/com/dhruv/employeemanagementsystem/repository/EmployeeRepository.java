package com.dhruv.employeemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhruv.employeemanagementsystem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  
}
