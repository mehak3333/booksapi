package com.assignment.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assignment.model.Book;
import com.assignment.repository.BookRepository;


@Service("bookService")
public class BooksServiceImpl implements BookService {
		
		@Autowired
		BookRepository bookRepository; 

		

		@Override
		public List<Book> getAllBooks() {
			return bookRepository.findAll();
		}
	
		@Override
		public Optional<Book> getBookById(long id) {
			return bookRepository.findById(id);
		}

		@Override
		public Map<String, String> deleteBookById(long id){
			bookRepository.deleteById(id);
			
			Map<String, String> data = new HashMap<String, String>();
	        data.put("Status", "Deleted");
			return data;
		}


		@Override
		public Book createBook(Book book){
			// TODO Auto-generated method stub
			Book bk = new Book(book.getName(), book.getLastName(), book.isActive());
			bookRepository.save(bk);
			return bk;
		}
		
		@Override
		public ResponseEntity<Object> updateBook(Book book, long id) {
			
			Optional<Book> bookOptional = bookRepository.findById(id);
			if (!bookOptional.isPresent())
				return ResponseEntity.notFound().build();

			book.setId(id);
			bookRepository.save(book);
			return ResponseEntity.noContent().build();
		}

		

		

		
	}



