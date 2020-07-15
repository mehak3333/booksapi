package com.assignment.service;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.assignment.model.Book;

public interface BookService {

	List<Book> getAllBooks();

	Optional<Book> getBookById(long id);


	Map<String, String> deleteBookById(long id);
	Book createBook(Book book);
//	Books updateBook(Books book, long id);
	ResponseEntity<Object> updateBook(Book book, long id);

	
}
