package com.invoice.task.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invoice.task.dto.InvoiceDTO;
import com.invoice.task.dto.InvoiceItemDTO;
import com.invoice.task.entity.Invoice;
import com.invoice.task.entity.InvoiceItem;
import com.invoice.task.exception.BadRequestAlertException;
import com.invoice.task.exception.InvoiceItemNotFoundException;
import com.invoice.task.exception.InvoiceNotFoundException;
import com.invoice.task.exception.ResourceNotFoundException;
import com.invoice.task.mapper.InvoiceItemMapper;
import com.invoice.task.mapper.InvoiceMapper;
import com.invoice.task.repository.InvoiceItemRepository;
import com.invoice.task.repository.InvoiceRepository;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {
	
	private final InvoiceItemRepository invoiceItemRepository ;
	private final InvoiceRepository invoiceRepository;

	public InvoiceItemServiceImpl(InvoiceItemRepository invoiceItemRepository, InvoiceRepository invoiceRepository) {
		this.invoiceItemRepository = invoiceItemRepository;
		this.invoiceRepository = invoiceRepository;
	}

	@Override
	@Transactional
	public InvoiceItemDTO save(InvoiceItemDTO dto) {
		Invoice invoice = invoiceRepository.findById(dto.getInvoiceId())
										   .orElseThrow(() -> new InvoiceNotFoundException("Invoice not found"));
		
		InvoiceItem item = InvoiceItemMapper.convertToEntity(dto, invoice);
		item = invoiceItemRepository.save(item);
		
		return InvoiceItemMapper.convertToDto(item);
	}
	
	@Override
	public List<InvoiceItemDTO> getInvoiceItemsByInvoice(InvoiceDTO dto) {
		
		Invoice invoice = InvoiceMapper.convertToEntity(dto);
		
		return invoiceItemRepository.findByInvoice(invoice)
									.stream()
									.map(InvoiceItemMapper::convertToDto)
									.collect(Collectors.toList());
	}

	@Override
	public Optional<InvoiceItemDTO> findById(Long id) {
		return invoiceItemRepository.findById(id)
									.map(InvoiceItemMapper::convertToDto);
	}

	@Override
	public InvoiceItemDTO update(Long id, InvoiceItemDTO dto) {

		if (dto.getId() == null || !Objects.equals(id, dto.getId())) {
	           throw new BadRequestAlertException("InvoiceItem ID mismatch: Provided ID does not match the entity ID.");
	    }
		
		InvoiceItem updatedItem = invoiceItemRepository.findById(id)
												.orElseThrow(() -> new ResourceNotFoundException("InvoiceItem not found with id: " + id));
		
		updatedItem.setQuantity(dto.getQuantity());
		updatedItem.setAmount(dto.getAmount());
		updatedItem.setName(dto.getName());
		updatedItem.setPrice(dto.getPrice());
		
		Invoice invoice = invoiceRepository.findById(dto.getInvoiceId())
									.orElseThrow(() -> new InvoiceNotFoundException("Invoice not found"));
		updatedItem.setInvoice(invoice);
		
		InvoiceItem saveUpdateItem = invoiceItemRepository.save(updatedItem);
		
		return InvoiceItemMapper.convertToDto(saveUpdateItem);
	}
	
	@Override
	public void delete(Long id) {
		if(!invoiceItemRepository.existsById(id)) {
			throw new InvoiceItemNotFoundException("Invoice Item with id " + id + " not found");
		}
		invoiceItemRepository.deleteById(id);
	}
	
	@Override
	public List<InvoiceItemDTO> findAll() {
		return invoiceItemRepository.findAll()
									.stream()
									.map(InvoiceItemMapper::convertToDto)
									.collect(Collectors.toList());
	}

}
