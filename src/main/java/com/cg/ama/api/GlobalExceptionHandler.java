package com.cg.ama.api;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ama.exception.AssetNotFoundException;
import com.cg.ama.exception.DuplicateEntryException;
import com.cg.ama.exception.InvalidAssetDetailsException;
import com.cg.ama.exception.InvalidShipmentDetailsException;
import com.cg.ama.exception.InvalidUserDetailsException;
import com.cg.ama.exception.LoginFailedException;
import com.cg.ama.exception.ShipmentNotFoundException;
import com.cg.ama.exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = {UserNotFoundException.class, ShipmentNotFoundException.class, AssetNotFoundException.class})
	public ResponseEntity<Object> handleUserNotFoundException(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value = {InvalidAssetDetailsException.class, InvalidShipmentDetailsException.class, InvalidUserDetailsException.class})
	public ResponseEntity<Object> handleInvalidExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {DuplicateEntryException.class})
	public ResponseEntity<Object> handleDuplicateExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = {LoginFailedException.class})
	public ResponseEntity<Object> LoginFailed(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.UNAUTHORIZED);
	}
	
		
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleAnyException(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	static String messageFrom(BindingResult result) {		
		return result.getAllErrors().stream()
				.map(err -> err.getObjectName() + "-"+err.getDefaultMessage())
				.collect(Collectors.toList()).toString();
	}
}
