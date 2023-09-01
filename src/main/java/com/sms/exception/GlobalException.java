package com.sms.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice // Accessible for all
public class GlobalException {

//	handler method for handling specific exception

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundHandling(ResourceNotFoundException ex, WebRequest request) {
//		new Date() -> will fetch the system time. 
		ErrorDetails errors = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}

}
