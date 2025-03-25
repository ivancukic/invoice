package com.invoice.task.service;

import java.util.List;
import java.util.Optional;

import com.invoice.task.entity.Customer;

public interface CustomerService {
	
	Customer save(Customer customer);
	
	List<Customer> findAll();
	
	void delete(Long id);
	
	Optional<Customer> findById(Long id);

}
