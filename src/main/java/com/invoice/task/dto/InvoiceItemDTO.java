package com.invoice.task.dto;

public class InvoiceItemDTO {
	
	private Long id;
    private Integer quantity;
    private Integer amount;
    private String name;
    private Integer price;
    private Long invoiceId;
    
    
	public InvoiceItemDTO() {

	}

	public InvoiceItemDTO(Long id, Integer quantity, Integer amount, String productName, Integer productPrice,
			Long invoiceId) {

		this.id = id;
		this.quantity = quantity;
		this.amount = amount;
		this.name = productName;
		this.price = productPrice;
		this.invoiceId = invoiceId;
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

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

}
