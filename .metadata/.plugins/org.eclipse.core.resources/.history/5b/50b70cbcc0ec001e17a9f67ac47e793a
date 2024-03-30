package com.studentdetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(value = AgeException.class)
	public ResponseEntity<Object> ageExceptionHandling(AgeException age) {
		return new ResponseEntity<>(age.getMessage(), HttpStatus.NOT_FOUND);
	}

}
