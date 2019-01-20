package com.core.serialization.performance;

import java.io.IOException;

import com.core.serialization.utils.SerializeUtils;

public class Test {
	public static void main(String[] args) throws IOException {
		UserInfo info = new UserInfo();
		info.buildUserInfo(123456789).buildUserName("summer");

		byte[] jdk = SerializeUtils.serialize(info);
		byte[] byteArray = info.getDataByteArray();

		System.out.println("The jdk serializable length is : " + jdk.length);
		System.out.println("The byte arrray serializable is : " + byteArray.length);
		System.out.println("The ratio is : " + (jdk.length / byteArray.length));
	}
}
