package com.bookstore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.UserPayment;
import com.bookstore.domain.UserShipping;
import com.bookstore.repository.UserShippingRepository;
import com.bookstore.service.UserShippingService;

@Service
public class UserShippingServiceImpl implements UserShippingService{
	
	@Autowired
	private UserShippingRepository userShippingRepository;
	
	public UserShipping findById(Long id) {
		Optional<UserShipping> result = userShippingRepository.findById(id);
		UserShipping userShipping = null;
		if(result.isPresent())
			userShipping = result.get();
		else
			throw new RuntimeException("Did not find shipping id - " + id);
		return userShipping;
	}
	
	
	public void removeById(Long id) {
		userShippingRepository.deleteById(id);
	}

}
