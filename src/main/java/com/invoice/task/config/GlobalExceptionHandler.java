package com.invoice.task.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.invoice.task.exception.CustomerNotFoundException;
import com.invoice.task.exception.InvoiceItemNotFoundException;
import com.invoice.task.exception.InvoiceNotFoundException;
import com.invoice.task.exception.ProductNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(code = org.springframework.http.HttpStatus.NOT_FOUND)
	public String handleCustomerNotFoundException(CustomerNotFoundException exception) {
		return exception.getMessage();
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(code = org.springframework.http.HttpStatus.NOT_FOUND)
	public String handleProductNotFoundException(ProductNotFoundException exception) {
		return exception.getMessage();
	}

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
}
