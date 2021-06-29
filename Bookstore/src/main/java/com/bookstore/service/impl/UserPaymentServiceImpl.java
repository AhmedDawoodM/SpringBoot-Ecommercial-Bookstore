package com.bookstore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Book;
import com.bookstore.domain.UserPayment;
import com.bookstore.repository.UserPaymentRepository;
import com.bookstore.service.UserPaymentService;

@Service
public class UserPaymentServiceImpl implements UserPaymentService{

	@Autowired
	private UserPaymentRepository userPaymentRepository;
		
	public UserPayment findById(Long id) {
		Optional<UserPayment> result = userPaymentRepository.findById(id);
		UserPayment userPayment = null;
		if(result.isPresent())
			userPayment = result.get();
		else
			throw new RuntimeException("Did not find payment id - " + id);
		return userPayment;
	}
	
	public void removeById(Long id) {
		userPaymentRepository.deleteById(id);
	}
} 
