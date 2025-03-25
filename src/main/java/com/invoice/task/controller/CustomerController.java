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

import com.invoice.task.entity.Customer;
import com.invoice.task.exception.CustomerNotFoundException;
import com.invoice.task.service.CustomerService;

@RequestMapping("/api/customers")
@RestController
public class CustomerController {
	
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> findAll() {
		
		List<Customer> customers = customerService.findAll();
		
		return ResponseEntity.ok(customers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
		return customerService.findById(id)
				.map(ResponseEntity::ok)
				.orElseThrow(() -> new CustomerNotFoundException("Customer with id " + id + " not found"));
	}
	
	@PostMapping
	ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer createdCustomer = customerService.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		customerService.delete(id);
		return ResponseEntity
				.noContent()
				.build();
	}

}
