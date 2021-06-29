package com.bookstore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> findAll() {
		return (List<Book>) bookRepository.findAll();
	}
	
	public Book findById(Long id) {
		Optional<Book> result = bookRepository.findById(id);
		Book book = null;
		if(result.isPresent())
			book = result.get();
		else
			throw new RuntimeException("Did not find book id - " + id);
		return book;
	}

}
