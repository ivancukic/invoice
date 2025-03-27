package com.invoice.task.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.task.dto.InvoiceDTO;
import com.invoice.task.exception.InvoiceNotFoundException;
import com.invoice.task.service.InvoiceService;

@RequestMapping("/api/invoices")
@RestController
public class InvoiceController {
	
	private final InvoiceService invoiceService;

	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	
	@PostMapping
	ResponseEntity<InvoiceDTO> createInvoice(@RequestBody InvoiceDTO dto) {
		InvoiceDTO createdInvoice = invoiceService.save(dto); 
	    return ResponseEntity.status(HttpStatus.CREATED).body(createdInvoice);
	}
	
	@GetMapping
	public ResponseEntity<List<InvoiceDTO>> findAll() {
		
		List<InvoiceDTO> invoices = invoiceService.findAll();
		
		return ResponseEntity.ok(invoices);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<InvoiceDTO> getInvoice(@PathVariable Long id) {
		return invoiceService.findById(id)
				.map(ResponseEntity::ok)
				.orElseThrow(() -> new InvoiceNotFoundException("Invoice with id " + id + " not found"));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<InvoiceDTO> updateInvoiceItem(@PathVariable Long id, @RequestBody InvoiceDTO dto) {
		InvoiceDTO updateItem = invoiceService.update(id, dto);
		return ResponseEntity.ok(updateItem);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
		invoiceService.delete(id);
		return ResponseEntity
				.noContent()
				.build();
	}
}
