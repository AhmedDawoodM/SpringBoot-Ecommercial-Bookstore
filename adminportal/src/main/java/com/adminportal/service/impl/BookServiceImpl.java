package com.adminportal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportal.domain.Book;
import com.adminportal.repository.BookRepository;
import com.adminportal.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book); 
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public Book findById(Long id) {
		// TODO Auto-generated method stub

		Optional<Book> result = bookRepository.findById(id);
		Book book = null;

		if(result.isPresent())
			book=result.get();
		else
			throw new RuntimeException("Did not find book id - " + id);

		return book;
	}



}
