package com.invoice.task.mapper;

import com.invoice.task.dto.InvoiceItemDTO;
import com.invoice.task.entity.Invoice;
import com.invoice.task.entity.InvoiceItem;

public class InvoiceItemMapper {
	
	public static InvoiceItemDTO convertToDto(InvoiceItem item) {
		return new InvoiceItemDTO(
				item.getId(), 
				item.getQuantity(), 
				item.getAmount(), 
				item.getName(), 
				item.getPrice(), 
				item.getInvoice().getId()
		);
	}
	
	public static InvoiceItem convertToEntity(InvoiceItemDTO dto, Invoice invoice) {
		InvoiceItem item = new InvoiceItem();
		
		item.setQuantity(dto.getQuantity());
		item.setAmount(dto.getAmount());
		item.setName(dto.getName());
		item.setPrice(dto.getPrice());
		item.setInvoice(invoice);
		
		return item;
	}

}
