package com.cognizant.UserProfile.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<String> handleUserExistsAlreadyException(UserAlreadyExistException exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
 
}
