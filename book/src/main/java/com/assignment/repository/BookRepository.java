package com.assignment.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.Book;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Long> {

	



}
