package com.sms.dto;

import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sms.entity.Role;

public class UserDTO {

	private String id;

	@NotNull(message = "Name is required")
	@Size(min = 2 , max = 30, message = "Minimum 2 and maximum 30 charracters allowed")
	@NotBlank(message = "Please enter correct name")
	private String name;

	@NotNull(message = "Email is required")
	@Size(max = 50, message = "Maximum 30 charracters allowed")
	@NotBlank(message = "Please enter correct name")
	@Email(message = "Invalid Email")
	private String email;

	private String userName;

	private String password;

	@OneToOne // one user can have only one role
	private Role role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
