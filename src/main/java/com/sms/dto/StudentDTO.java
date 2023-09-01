package com.sms.dto;

import java.time.LocalDate;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sms.entity.Address;
import com.sms.entity.Department;

public class StudentDTO extends UserDTO{

	@NotNull(message = "Date of birth is required")
	private LocalDate dateOfBirth;// yyyy-mm-dd

	@NotNull(message = "Date of join is required")
	private LocalDate dateOfJoining;

	@NotNull(message = "Contact is Required")
	@Pattern(regexp = "[6789]{1}[0-9]{9}",message = "Invalid contact details")	//[starting should me from 6,7,8,9,]{position}[range of number]{how much number it will take}
	@Size(min = 10, max = 10)
	private String contact;

	@OneToOne // one student can have only one address
	private Address address;

	@ManyToOne // many students can belong to one department
	private Department dept;

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
	
	

}
