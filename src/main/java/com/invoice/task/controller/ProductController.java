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

import com.invoice.task.entity.Product;
import com.invoice.task.exception.ProductNotFoundException;
import com.invoice.task.service.ProductService;

@RequestMapping("/api/products")
@RestController
public class ProductController {
	
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		
		List<Product> products = productService.findAll();
		
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getCustomer(@PathVariable Long id) {
		return productService.findById(id)
				.map(ResponseEntity::ok)
				.orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
	}
	
	@PostMapping
	ResponseEntity<Product> createCustomer(@RequestBody Product product) {
		Product createdProduct = productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		productService.delete(id);
		return ResponseEntity
				.noContent()
				.build();
	}

}
