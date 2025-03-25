package com.invoice.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice_items")
public class InvoiceItem {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Integer quantity;
	
	@Column
	private Integer amount;
	
	@ManyToOne
	@JoinColumn(name = "invoice_id", referencedColumnName = "id", nullable = false)
	@JsonIgnoreProperties("items")
	private Invoice invoice;
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
	private Product product;

	public InvoiceItem() {
		
	}

	public InvoiceItem(Integer quantity, Integer amount, Invoice invoice, Product product) {
		this.quantity = quantity;
		this.amount = amount;
		this.invoice = invoice;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "InvoiceItem [id=" + id + ", quantity=" + quantity + ", amount=" + amount + ", invoice=" + invoice
				+ ", product=" + product + "]";
	}
	
}
