package com.bkend.app.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkend.app.backend.exception.ResourceNotFoundException;
import com.bkend.app.backend.model.Employee;
import com.bkend.app.backend.repository.EmployeeRepository;
import com.bkend.app.backend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) 
	{
		 
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeById(long id)
	{
		return employeeRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Employee","id",id));
	}


	@Override
	public Employee updateEmployee(Employee employee, long id)
	{
		Employee existingEmployee =employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee","Id",id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		employeeRepository.save(existingEmployee);
		
		
		return existingEmployee;
	}


	@Override
	public void deleteEmployee(long id)
	{
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));
		employeeRepository.deleteById(id);
		
	}


	
	

}
