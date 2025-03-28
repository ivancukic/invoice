package com.invoice.task.entity;

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

	@Column
	private String name;

	@Column
	private Integer price;

	@ManyToOne
	@JoinColumn(name = "invoice_id", referencedColumnName = "id", nullable = false)
	private Invoice invoice;

	public InvoiceItem() {

	}

	public InvoiceItem(Long id, Integer quantity, Integer amount, String name, Integer price, Invoice invoice) {
		this.id = id;
		this.quantity = quantity;
		this.amount = amount;
		this.name = name;
		this.price = price;
		this.invoice = invoice;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "InvoiceItem [id=" + id + ", quantity=" + quantity + ", amount=" + amount + ", name=" + name + ", price="
				+ price + ", invoice=" + invoice + "]";
	}
	
}
