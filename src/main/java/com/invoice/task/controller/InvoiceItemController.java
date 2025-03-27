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
import com.invoice.task.dto.InvoiceItemDTO;
import com.invoice.task.exception.InvoiceItemNotFoundException;
import com.invoice.task.service.InvoiceItemService;

@RequestMapping("/api/invoice-items")
@RestController
public class InvoiceItemController {
	
	private final InvoiceItemService invoiceItemService;

	public InvoiceItemController(InvoiceItemService invoiceItemService) {
		this.invoiceItemService = invoiceItemService;
	}
	
	@PostMapping
	ResponseEntity<InvoiceItemDTO> createInvoiceItem(@RequestBody InvoiceItemDTO dto) {
		InvoiceItemDTO saveInvoiceItem = invoiceItemService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveInvoiceItem);
	}
	
	@GetMapping("/search-by-invoice")
	public ResponseEntity<List<InvoiceItemDTO>> getInvoiceItemsByInvoice(@RequestBody InvoiceDTO dto) {	
		List<InvoiceItemDTO> items = invoiceItemService.getInvoiceItemsByInvoice(dto);
		return ResponseEntity.ok(items);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<InvoiceItemDTO> getInvoiceItem(@PathVariable Long id) {
		return invoiceItemService.findById(id)
				.map(ResponseEntity::ok)
				.orElseThrow(() -> new InvoiceItemNotFoundException("Invoice Item with id " + id + " not found"));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<InvoiceItemDTO> updateInvoiceItem(@PathVariable Long id, @RequestBody InvoiceItemDTO dto) {
		InvoiceItemDTO updateItem = invoiceItemService.update(id, dto);
		return ResponseEntity.ok(updateItem);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
		invoiceItemService.delete(id);
		return ResponseEntity
				.noContent()
				.build();
	}
	
	@GetMapping
	public ResponseEntity<List<InvoiceItemDTO>> findAll() {
		List<InvoiceItemDTO> invoiceItems = invoiceItemService.findAll();
		return ResponseEntity.ok(invoiceItems);
	}

}
