package com.invoice.task.service;

import java.util.List;
import java.util.Optional;

import com.invoice.task.dto.InvoiceDTO;
import com.invoice.task.dto.InvoiceItemDTO;


public interface InvoiceItemService {
	
	InvoiceItemDTO save(InvoiceItemDTO invoiceItemDTO);
	
	List<InvoiceItemDTO> getInvoiceItemsByInvoice(InvoiceDTO invoiceDTO);
	
	Optional<InvoiceItemDTO> findById(Long id);
	
	InvoiceItemDTO update(Long id, InvoiceItemDTO invoiceItemDTO);
	
	void delete(Long id);
	
	List<InvoiceItemDTO> findAll();

}
