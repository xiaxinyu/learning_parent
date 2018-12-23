package com.learning.web.server.core;

import java.io.IOException;
import java.io.OutputStream;

import com.learning.web.server.utils.ResponseHelper;

/**
 * Created by summer.xia on 2018.12.19
 * 
 * @author summer
 */
public class Response {
	private OutputStream os;
	private HttpStatus status;

	public Response(OutputStream os) {
		this.os = os;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public void write(String outContext) throws IOException {
		os.write(ResponseHelper.fmtResponse(outContext).getBytes());
	}
}
