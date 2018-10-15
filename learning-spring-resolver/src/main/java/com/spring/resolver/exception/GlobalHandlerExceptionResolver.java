package com.spring.resolver.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {
	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		logger.info("System error happen.");

		Map<String, Object> model = new HashMap<String, Object>();

		if (ex instanceof HelloException) {
			logger.error("HelloException-" + ex.getMessage(), ex);
		}

		if (ex instanceof WorldException) {
			logger.error("WorldException-" + ex.getMessage(), ex);
		}

		return new ModelAndView("system-error", model);
	}
}
