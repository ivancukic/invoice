package com.invoice.task.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invoice.task.dto.InvoiceDTO;
import com.invoice.task.entity.Invoice;
import com.invoice.task.exception.BadRequestAlertException;
import com.invoice.task.exception.InvoiceNotFoundException;
import com.invoice.task.exception.ResourceNotFoundException;
import com.invoice.task.mapper.InvoiceMapper;
import com.invoice.task.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	private final InvoiceRepository invoiceRepository;

	public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}
	
	@Override
	@Transactional
	public InvoiceDTO save(InvoiceDTO dto) {
		Invoice invoice = InvoiceMapper.convertToEntity(dto);
		
		Invoice saved = invoiceRepository.save(invoice);
		
		return InvoiceMapper.convertToDto(saved);
	}

	@Override
	public List<InvoiceDTO> findAll() {
		return invoiceRepository.findAll()
                .stream()
                .map(InvoiceMapper::convertToDto)
                .collect(Collectors.toList());
	}
	
	@Override
	public Optional<InvoiceDTO> findById(Long id) {
		return invoiceRepository.findById(id)
								.map(InvoiceMapper::convertToDto);
	}
	
	@Override
	public InvoiceDTO update(Long id, InvoiceDTO dto) {
		if (dto.getId() == null || !Objects.equals(id, dto.getId())) {
            throw new BadRequestAlertException("Invoice ID mismatch: Provided ID does not match the entity ID.");
        }

        Invoice updatedInvoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with id: " + id));

        updatedInvoice.setInvoiceNumber(dto.getInvoiceNumber());
        updatedInvoice.setIssueDate(dto.getIssueDate());
        updatedInvoice.setFirstName(dto.getFirstName());
        updatedInvoice.setLastName(dto.getLastName());
        updatedInvoice.setAddress(dto.getAddress());
        updatedInvoice.setTotalAmount(dto.getTotalAmount());

        updatedInvoice = invoiceRepository.save(updatedInvoice);

        return InvoiceMapper.convertToDto(updatedInvoice);
	}

	@Override
	public void delete(Long id) {
		if(!invoiceRepository.existsById(id)) {
			throw new InvoiceNotFoundException("Invoice with id " + id + " not found");
		}
		invoiceRepository.deleteById(id);
	}

}
