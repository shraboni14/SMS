package com.sms.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String resourceName; // searching for what? like department? student?

	private String fieldName; // searching for which field?

	private Object fieldValue; // which field(id/name) I'm searching

//	public ResourceNotFoundException(String message) {
//		super(message);	// employee not found with id 99
//	}

//	creating constructor
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'" , resourceName , fieldName , fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
