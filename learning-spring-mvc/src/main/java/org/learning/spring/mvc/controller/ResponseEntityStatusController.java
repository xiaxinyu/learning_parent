package org.learning.spring.mvc.controller;

import org.learning.spring.mvc.vo.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseEntityStatusController {
	@RequestMapping(value = "/res/ok", method = RequestMethod.GET)
	public ResponseEntity<Response> ok() {
		return ResponseEntity.ok(new Response(Response.Type.OK.name(), "It's OK!"));
	}

	@RequestMapping(value = "/res/bad-request", method = RequestMethod.GET)
	public ResponseEntity<Response> badRequest() {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new Response(Response.Type.INVOLID_PARAMETER.name(), "INVOLID_PARAMETER"));
	}

	@RequestMapping(value = "/res/internal-error", method = RequestMethod.GET)
	public ResponseEntity<Response> internalError() {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new Response(Response.Type.INTERNEL_ERROR.name(), "INTERNEL_ERROR"));
	}
}
