package com.sms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Builder;

@Entity
public class Student extends User {

	@Column(nullable = false)
	private LocalDate dateOfBirth;// yyyy-mm-dd

	@Column(nullable = false)
	private LocalDate dateOfJoining;

	@Column(length = 20, nullable = false, unique = true)
	private String contact;

	@OneToOne // one student can have only one address
	private Address address;

	@ManyToOne // many students can belong to one department
	private Department dept;

	// -----------------------------------------------------------------------------------------------

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Builder
	public Student(String id, String name, String email, String userName, String password, Role role,
			LocalDate dateOfBirth, LocalDate dateOfJoining, String contact, Address address, Department dept) {
		super(id, name, email, userName, password, role);
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.contact = contact;
		this.address = address;
		this.dept = dept;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	
	

}
