package com.spring.resolver.service;

import org.springframework.stereotype.Service;

import com.spring.resolver.exception.HelloException;
import com.spring.resolver.exception.WorldException;

@Service
public class HomeService {
	public void sayHello() throws HelloException {
		throw new HelloException("SayHello has error.");
	}

	public void sayWorld() throws WorldException {
		throw new WorldException("SayWorld has error.");
	}
}
