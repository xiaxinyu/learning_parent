package com.learning.web.server.core.external;

import com.learning.web.server.core.Request;
import com.learning.web.server.core.Response;
import com.learning.web.server.core.Servlet;

public class FirstServlet extends Servlet {
	@Override
	public void doGet(Request request, Response response) throws Exception {
		response.write("FirstServlet.do");
	}

	@Override
	public void doPost(Request request, Response response) throws Exception {
	}
}