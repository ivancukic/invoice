package com.invoice.task.config;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.invoice.task.exception.BadRequestAlertException;
import com.invoice.task.exception.InvoiceItemNotFoundException;
import com.invoice.task.exception.InvoiceNotFoundException;
import com.invoice.task.exception.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvoiceNotFoundException.class)
	@ResponseStatus(code = org.springframework.http.HttpStatus.NOT_FOUND)
	public String handleInvoiceNotFoundException(InvoiceNotFoundException exception) {
		return exception.getMessage();
	}
	
	@ExceptionHandler(InvoiceItemNotFoundException.class)
	@ResponseStatus(code = org.springframework.http.HttpStatus.NOT_FOUND)
	public String handleInvoiceItemNotFoundException(InvoiceItemNotFoundException exception) {
		return exception.getMessage();
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException exception) {
		Map<String, Object> errorResponse = new HashMap<String, Object>();
		
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("status", HttpStatus.NOT_FOUND.value());
		errorResponse.put("error", "Resource Not Found");
		errorResponse.put("message", exception.getMessage());
		
		return new ResponseEntity<Map<String,Object>>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadRequestAlertException.class)
	public ResponseEntity<Map<String, Object>> handleBadRequestException(BadRequestAlertException exeption) {
	    Map<String, Object> errorResponse = new HashMap<>();
	    errorResponse.put("timestamp", LocalDateTime.now());
	    errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
	    errorResponse.put("error", "Bad Request");
	    errorResponse.put("message", exeption.getMessage());

	    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
