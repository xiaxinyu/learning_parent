package org.rpc.api;

import org.rpc.api.bean.Person;

public interface SaHelloService {
	String sayHello(String name);
	Person getPerson(String name);
}
