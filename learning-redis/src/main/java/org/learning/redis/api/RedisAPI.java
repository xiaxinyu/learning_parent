package org.learning.redis.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedisAPI {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@RequestMapping(value = "/api/addRequest", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Response> addRequest(@RequestBody final Request reuqest) {
		Response result = redisTemplate.execute(new RedisCallback<Response>() {
			@Override
			public Response doInRedis(RedisConnection connection) throws DataAccessException {
				connection.set(reuqest.getId().getBytes(), reuqest.getContent().getBytes());
				return Response.SUCCESS;
			}
		});
		if (result == Response.SUCCESS) {
			return new ResponseEntity<RedisAPI.Response>(Response.SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<RedisAPI.Response>(Response.FAIL, HttpStatus.BAD_REQUEST);
		}
	}

	static enum Response {
		SUCCESS, FAIL, EXCEPTION, ERROR
	}

	static class Request {
		String id;
		String content;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		@Override
		public String toString() {
			return "Request [id=" + id + ", content=" + content + "]";
		}
	}
}
