package com.invoice.task.service;

import java.util.List;
import java.util.Optional;

import com.invoice.task.entity.Product;


public interface ProductService {
	
	Product save(Product product);
	
	List<Product> findAll();
	
	void delete(Long id);
	
	Optional<Product> findById(Long id);

}
