package com.invoice.task.dto;

import java.time.LocalDate;


public class InvoiceDTO {

    private Long id;
    private String invoiceNumber;
    private LocalDate issueDate;
    private String firstName;
    private String lastName;
    private String address;
    private Long totalAmount;
    
    
	public InvoiceDTO() {
		
	}

	public InvoiceDTO(Long id, String invoiceNumber, LocalDate issueDate, String firstName, String lastName,
			String address, Long totalAmount) {

		this.id = id;
		this.invoiceNumber = invoiceNumber;
		this.issueDate = issueDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.totalAmount = totalAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

}
