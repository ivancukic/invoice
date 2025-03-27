package com.invoice.task.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.invoice.task.filter.RequestLoggingFilter;

@Configuration
public class FilterConfig {
	
	@Bean
    public FilterRegistrationBean<RequestLoggingFilter> loggingFilter(RequestLoggingFilter requestLoggingFilter) {
        FilterRegistrationBean<RequestLoggingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(requestLoggingFilter);  // Let Spring inject the filter with the necessary dependencies
        registrationBean.addUrlPatterns("/api/*");  // Specify URL patterns to log
        return registrationBean;
    }

}
