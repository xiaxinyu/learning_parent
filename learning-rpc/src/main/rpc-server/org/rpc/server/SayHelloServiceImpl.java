package org.rpc.server;

import org.rpc.api.SaHelloService;
import org.rpc.api.bean.Person;

public class SayHelloServiceImpl implements SaHelloService {
	public String sayHello(String name) {
		return "hello,"+name;
	}

	public Person getPerson(String name) {
		Person person = new Person();
		person.setName(name);
		person.setAge(20);
		return person;
	}
}
