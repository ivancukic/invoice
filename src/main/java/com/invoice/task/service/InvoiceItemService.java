package com.invoice.task.service;

import java.util.List;
import java.util.Optional;

import com.invoice.task.entity.InvoiceItem;


public interface InvoiceItemService {
	
	InvoiceItem save(InvoiceItem invoiceItem);
	
	List<InvoiceItem> findAll();
	
	void delete(Long id);
	
	Optional<InvoiceItem> findById(Long id);

}
