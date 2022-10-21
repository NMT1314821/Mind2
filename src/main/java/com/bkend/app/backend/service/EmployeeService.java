package com.bkend.app.backend.service;

import java.util.List;

import com.bkend.app.backend.model.Employee;

public interface EmployeeService
{
	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployees();
	
	Employee getEmployeById(long id);
	
	Employee updateEmployee(Employee employee,long id);
	
	void deleteEmployee(long id);
}
