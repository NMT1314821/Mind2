package com.bkend.app.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bkend.app.backend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
	
}
