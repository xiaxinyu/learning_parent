package com.learning.web.server.core;

import com.learning.web.server.exception.NotSupportMethodTypeException;

/**
 * Created by summer.xia on 2018.12.23
 * 
 * @author summer
 *
 */
public abstract class Servlet {
	public void service(Request request, Response response) throws Exception {
		if (MethodType.GET == request.getMethod()) {
			doGet(request, response);
		} else if (MethodType.POST == request.getMethod()) {
			doPost(request, response);
		} else {
			throw new NotSupportMethodTypeException(request.getMethod() + " can't be support.");
		}
	}

	public abstract void doGet(Request request, Response response) throws Exception;

	public abstract void doPost(Request request, Response response) throws Exception;
}