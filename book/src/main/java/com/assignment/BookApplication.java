package com.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;




import com.assignment.repository.BookRepository;
import com.assignment.model.Book;




@SpringBootApplication
public class BookApplication {
	private static final Logger logger = LoggerFactory.getLogger(BookApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	
	}
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

