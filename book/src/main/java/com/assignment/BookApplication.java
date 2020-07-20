package com.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.smile.MappingJackson2SmileHttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.assignment.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.codecentric.boot.admin.server.domain.entities.Application;

import com.assignment.model.Book;



@SpringBootApplication
public class BookApplication {
	private static final Logger logger = LoggerFactory.getLogger(BookApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	
	}
//	@Bean
//	RestTemplate restTemplate() {
//		RestTemplate restTemplate = new RestTemplate();
//		MappingJackson2SmileHttpMessageConverter converter = new MappingJackson2SmileHttpMessageConverter();
//		converter.setObjectMapper(new ObjectMapper());
//		restTemplate.getMessageConverters().add(converter);
//		return restTemplate;
//	}
	@Bean
	public CommandLineRunner setup(BookRepository bookRepository) {
		return (args) -> {
			bookRepository.save(new Book("Gustavo", "Ponce", true));
			bookRepository.save(new Book("John", "Smith", true));
			bookRepository.save(new Book("Jim ", "Morrison", false));
			bookRepository.save(new Book("David", "Gilmour", true));
	
			logger.info("The sample data has been generated");
		};
	}
}

