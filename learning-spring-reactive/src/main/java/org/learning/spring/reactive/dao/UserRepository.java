package org.learning.spring.reactive.dao;

import java.util.Arrays;
import java.util.List;

import org.learning.spring.reactive.beans.User;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserRepository {
	private final List<User> users = Arrays.asList(new User(1L, "User1"), new User(2L, "User2"));

	public Mono<User> getUserById(String id) {
		return Mono.justOrEmpty(users.stream().filter(user -> {
			return user.getId().equals(Long.valueOf(id));
		}).findFirst().orElse(null));
	}

	public Flux<User> getUsers() {
		return Flux.fromIterable(users);
	}
}
