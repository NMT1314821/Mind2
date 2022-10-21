package com.bkend.app.backend.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bkend.app.backend.model.Employee;
import com.bkend.app.backend.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController
{
	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService)
	{
		super();
		this.employeeService=employeeService;
	}
	
	//build create employee REST 
	
	@PostMapping("/insert")
	public ResponseEntity<Employee>  saveEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping("/retrive")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")long employeeId)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployeById(employeeId),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id)
	{
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("employee deleted successfully",HttpStatus.OK);
	}
	
}
