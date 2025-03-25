package com.invoice.task.service;

import java.util.List;
import java.util.Optional;

import com.invoice.task.entity.Invoice;

public interface InvoiceService {
	
	Invoice save(Invoice invoice);
	
	List<Invoice> findAll();
	
	void delete(Long id);
	
	Optional<Invoice> findById(Long id);

}
