package com.invoice.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invoice.task.entity.Invoice;
import com.invoice.task.entity.InvoiceItem;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
	
	List<InvoiceItem> findByInvoice(Invoice invoice);

}

