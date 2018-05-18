package com.learning.javaee.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AppFilter implements Filter {
	@Override
	public void destroy() {
		System.out.println("AppFilter is destroying");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("AppFilter is filtering before");
		chain.doFilter(request, response);
		System.out.println("AppFilter is filtering after");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("AppFilter is initializing");
	}
}
