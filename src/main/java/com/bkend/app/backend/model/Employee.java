package com.bkend.app.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name="employees")

public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column(name="first_Name",nullable=false)
	private String firstName;
	@Column(name="last_Name")
	private String lastName;
	@Column(name="Email")
	private String Email;
	
	public Employee()
	{
	}
	
	
	public Employee(long id, String firstName, String lastName, String email)
	{
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		Email = email;
	}


	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}
	
}
