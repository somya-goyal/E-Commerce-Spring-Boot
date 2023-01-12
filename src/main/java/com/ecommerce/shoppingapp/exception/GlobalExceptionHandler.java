package com.ecommerce.shoppingapp.exception;

import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException) {
		return new ResponseEntity<String>(emptyInputException.getErrorMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handleEmptyResultDataAccess(EmptyResultDataAccessException emptyResultDataAccessException) {
		return new ResponseEntity<String>("No value is present in DB. Please change your request.", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException)
	{
		return new ResponseEntity<String>("No Data is present in DB for your request. Please change it.", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(LessQuantityAvailableException.class)
	public ResponseEntity<String> LessQuantityAvailableException(LessQuantityAvailableException lessQuantityAvailableException)
	{
		return new ResponseEntity<String>(lessQuantityAvailableException.getErrorMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException)
	{
		return new ResponseEntity<String>("Entity with this id is not found",HttpStatus.NOT_FOUND);
	}
}
