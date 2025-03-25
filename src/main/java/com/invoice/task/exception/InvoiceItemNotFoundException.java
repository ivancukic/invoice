package com.invoice.task.exception;

public class InvoiceItemNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvoiceItemNotFoundException(String message) {
		super(message);
	}

}
