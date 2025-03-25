package com.invoice.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invoice.task.entity.Invoice;
import com.invoice.task.exception.InvoiceNotFoundException;
import com.invoice.task.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	private final InvoiceRepository invoiceRepository;

	public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}
	
	@Override
	@Transactional
	public Invoice save(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

	@Override
	public List<Invoice> findAll() {
		return invoiceRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		if(!invoiceRepository.existsById(id)) {
			throw new InvoiceNotFoundException("Invoice with id " + id + " not found");
		}
		invoiceRepository.deleteById(id);
	}

	@Override
	public Optional<Invoice> findById(Long id) {
		return invoiceRepository.findById(id);
	}

}
