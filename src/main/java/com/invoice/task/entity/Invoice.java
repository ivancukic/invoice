package com.invoice.task.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String invoiceNumber;
	
	@Column
	private LocalDate issueDate;
	
	// Customer
	@Column
	private String firstName;	
	@Column
	private String lastName;
	@Column
	private String address;
	
	@Column
	private Long totalAmount;
	
	@OneToMany(mappedBy = "invoice", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = true)
	private List<InvoiceItem> items;

	public Invoice() {

	}

	public Invoice(String invoiceNumber, LocalDate issueDate, String firstName, String lastName, String address,
		Long totalAmount) {
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

	public List<InvoiceItem> getItems() {
		return items;
	}

	public void setItems(List<InvoiceItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", invoiceNumber=" + invoiceNumber + ", issueDate=" + issueDate + ", firstName="
				+ firstName + ", lastName=" + lastName + ", address=" + address + ", totalAmount=" + totalAmount
				+ ", items=" + items + "]";
	}
	
}
