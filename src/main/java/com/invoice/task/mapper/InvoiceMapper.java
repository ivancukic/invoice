package com.invoice.task.mapper;

import com.invoice.task.dto.InvoiceDTO;
import com.invoice.task.entity.Invoice;

public class InvoiceMapper {

    public static InvoiceDTO convertToDto(Invoice invoice) {
        return new InvoiceDTO(
                invoice.getId(),
                invoice.getInvoiceNumber(),
                invoice.getIssueDate(),
                invoice.getFirstName(),
                invoice.getLastName(),
                invoice.getAddress(),
                invoice.getTotalAmount()
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
        return invoice;
    }
}
