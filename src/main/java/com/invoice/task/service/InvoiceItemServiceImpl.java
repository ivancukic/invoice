package com.invoice.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invoice.task.entity.InvoiceItem;
import com.invoice.task.exception.InvoiceItemNotFoundException;
import com.invoice.task.repository.InvoiceItemRepository;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {
	
	private final InvoiceItemRepository invoiceItemRepository ;

	public InvoiceItemServiceImpl(InvoiceItemRepository invoiceItemRepository) {
		this.invoiceItemRepository = invoiceItemRepository;
	}
	
	@Override
	@Transactional
	public InvoiceItem save(InvoiceItem invoiceItem) {
		return invoiceItemRepository.save(invoiceItem);
	}

	@Override
	public List<InvoiceItem> findAll() {
		return invoiceItemRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		if(!invoiceItemRepository.existsById(id)) {
			throw new InvoiceItemNotFoundException("Invoice Item with id " + id + " not found");
		}
		invoiceItemRepository.deleteById(id);
	}

	@Override
	public Optional<InvoiceItem> findById(Long id) {
		return invoiceItemRepository.findById(id);
	}

}
