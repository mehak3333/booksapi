package com.assignment.book;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.assignment.model.Book;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
class BookApplicationTests {

	@Autowired
    private RestTemplate restTemplate;

    @LocalServerPort
    private int port;

    public String getRootUrl() {
        return "http://localhost:" + port;
    }
	
	
	@Test
	void contextLoads() {
	}
	

	 @Test
	    public void testGetBookById() {
		 port = 8080;
		 restTemplate = new RestTemplate();
	      Book book = restTemplate.getForObject(getRootUrl() + "/books/1", Book.class);
	      System.out.println(book.getName());	      
	     assertNotNull(book);

	    }
	    @Test
	    public void testBookEmployee() {
	    	port = 8080;
			 restTemplate = new RestTemplate();
	        Book book = new Book();
	        book.setLastName("harry");
	        book.setLastName("porter");
	        book.setActive(true);
	        ResponseEntity<Book> postBook = restTemplate.postForEntity(getRootUrl() + "/books", book, Book.class);
	        assertNotNull(postBook);
	        assertNotNull(postBook.getBody());
	    }
	    @Test
	    public void testUpdateBook() {
	    	port = 8080;
			 restTemplate = new RestTemplate();
	        int id = 1;
	        Book book = restTemplate.getForObject(getRootUrl() + "/books/" + id, Book.class);
	        book.setName("the great");
	        book.setLastName("gatesby");
	        restTemplate.put(getRootUrl() + "/books/" + id, book);
	        Book updatedBook = restTemplate.getForObject(getRootUrl() + "/books/" + id, Book.class);
	        assertNotNull(updatedBook);
	    }

	    @Test
	    public void testDeleteEmployee() {
	    	port = 8080;
			 restTemplate = new RestTemplate();
	         int id = 2;
	         Book book = restTemplate.getForObject(getRootUrl() + "/books/" + id, Book.class);
	         assertNotNull(book	);
	         restTemplate.delete(getRootUrl() + "/books/" + id);
	         try {
	              book = restTemplate.getForObject(getRootUrl() + "/books/" + id, Book.class);
	         } catch (final HttpClientErrorException e) {
	              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
	         }
	    }
	
}


