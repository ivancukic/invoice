package com.invoice.task.service;

import java.util.List;
import java.util.Optional;

import com.invoice.task.dto.InvoiceDTO;

public interface InvoiceService {
	
	InvoiceDTO save(InvoiceDTO invoiceDTO);
	
	List<InvoiceDTO> findAll();
	
	Optional<InvoiceDTO> findById(Long id);
	
	InvoiceDTO update(Long id, InvoiceDTO invoiceDTO);
	
	void delete(Long id);

}
