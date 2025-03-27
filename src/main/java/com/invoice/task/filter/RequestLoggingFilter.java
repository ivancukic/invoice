package com.invoice.task.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.invoice.task.producer.KafkaProducerService;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class RequestLoggingFilter implements Filter {
	
	private final KafkaProducerService kafkaProducerService;

	public RequestLoggingFilter(KafkaProducerService kafkaProducerService) {
		this.kafkaProducerService = kafkaProducerService;
	}

	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String logMessage = String.format("Method: %s, URI: %s, Remote Address: %s",
                                          req.getMethod(), req.getRequestURI(), req.getRemoteAddr());
        
        kafkaProducerService.sendLog(logMessage);

        chain.doFilter(request, response);
    }
}
