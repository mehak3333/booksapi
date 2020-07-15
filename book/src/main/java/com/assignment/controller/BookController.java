package com.assignment.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.Book;
import com.assignment.service.BookService;

@RestController

public class BookController {

	@Autowired
	private BookService bookService;

	 @RequestMapping(value = "/books", method = RequestMethod.GET)
	    public List<Book> getBooks() {
			return bookService.getAllBooks();
		}
	 
	  @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	    public Optional<Book> getBookById(@PathVariable("id") long id) {
			return bookService.getBookById(id);
		}

	  @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	    public Map<String, String> deleteBook(@PathVariable("id") long id) {
			return bookService.deleteBookById(id);
		}
	
	  @RequestMapping(value = "/books", method = RequestMethod.POST)
	    public Book createBook(@RequestBody Book book) {
			return (Book) bookService.createBook(book);
		}

	  @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
	  public ResponseEntity<Object> updateBook(@RequestBody Book book, @PathVariable long id) {
			return bookService.updateBook(book,id);
		}

}

