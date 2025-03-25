package com.invoice.task.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.task.entity.InvoiceItem;
import com.invoice.task.exception.InvoiceItemNotFoundException;
import com.invoice.task.service.InvoiceItemService;

@RequestMapping("/api/invoice-items")
@RestController
public class InvoiceItemController {
	
	private final InvoiceItemService invoiceItemService;

	public InvoiceItemController(InvoiceItemService invoiceItemService) {
		this.invoiceItemService = invoiceItemService;
	}
	
	@GetMapping
	public ResponseEntity<List<InvoiceItem>> findAll() {
		
		List<InvoiceItem> invoiceItems = invoiceItemService.findAll();
		
		return ResponseEntity.ok(invoiceItems);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<InvoiceItem> getCustomer(@PathVariable Long id) {
		return invoiceItemService.findById(id)
				.map(ResponseEntity::ok)
				.orElseThrow(() -> new InvoiceItemNotFoundException("Invoice Item with id " + id + " not found"));
	}
	
	@PostMapping
	ResponseEntity<InvoiceItem> createCustomer(@RequestBody InvoiceItem invoiceItem) {
		InvoiceItem createdInvoiceItem = invoiceItemService.save(invoiceItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInvoiceItem);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
		invoiceItemService.delete(id);
		return ResponseEntity
				.noContent()
				.build();
	}

}
