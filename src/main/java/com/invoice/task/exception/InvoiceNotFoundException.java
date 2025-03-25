package com.invoice.task.exception;

public class InvoiceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvoiceNotFoundException(String message) {
		super(message);
	}

}
