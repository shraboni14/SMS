package com.sms.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddressDTO {

	
	private int addId;

	@Size(max = 100, message = "Maximum limit is 100")
	@NotNull(message = "locslity is required")
	private String locality;

	@Size(max = 50,min = 2, message = "Maximum limit is 100")
	@NotNull(message = "city is required")
	private String city;

	@Size(max = 30, min = 3, message = "Maximum limit is 100")
	@NotNull(message = "state is required")
	private String state;

	@NotNull(message = "pincode is required")
	@Size(min = 6, max = 6 , message = "6 charracter required")
	private int pincode;

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	

}
