package org.rpc.api;

import java.io.IOException;

import org.rpc.api.bean.Person;
import org.rpc.api.util.SerializeUtils;

public class SerializeTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Person person = new Person();
		person.setAge(20);
		person.setName("zhangsan");
		byte[] byte1 = SerializeUtils.serialize(person);
		System.out.println("JDK:" + byte1.length);
		System.out.println(SerializeUtils.deSerialize(byte1));
	}
}