package com.invoice.task.mapper;

import java.util.Collections;
import java.util.List;

import com.invoice.task.dto.InvoiceDTO;
import com.invoice.task.dto.InvoiceItemDTO;
import com.invoice.task.entity.Invoice;
import com.invoice.task.entity.InvoiceItem;

public class InvoiceMapper {
	
	public static InvoiceDTO convertToDto(Invoice invoice) {
		List<InvoiceItemDTO> items = invoice.getItems() != null
				? invoice.getItems().stream().map(InvoiceItemMapper::convertToDto).toList()
				: Collections.emptyList();
		return new InvoiceDTO(
				invoice.getId(), 
				invoice.getInvoiceNumber(), 
				invoice.getIssueDate(), 
				invoice.getFirstName(), 
				invoice.getLastName(), 
				invoice.getAddress(), 
				invoice.getTotalAmount(),
				items
		);
	}
	
	public static Invoice convertToEntity(InvoiceDTO dto) {
		Invoice invoice = new Invoice();
		
		invoice.setId(dto.getId());
		invoice.setInvoiceNumber(dto.getInvoiceNumber());
		invoice.setIssueDate(dto.getIssueDate());
		invoice.setFirstName(dto.getFirstName());
		invoice.setLastName(dto.getLastName());
		invoice.setAddress(dto.getAddress());
		invoice.setTotalAmount(dto.getTotalAmount());
		
		if (dto.getItems() != null) {
			List<InvoiceItem> items = dto.getItems().stream()
					.map(itemDto -> InvoiceItemMapper.convertToEntity(itemDto, invoice))
					.toList();
			invoice.setItems(items);
		}
		
		return invoice;
	}

}
