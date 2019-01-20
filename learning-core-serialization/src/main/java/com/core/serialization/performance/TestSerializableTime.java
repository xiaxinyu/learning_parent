package com.core.serialization.performance;

import java.io.IOException;

import com.core.serialization.utils.SerializeUtils;

public class TestSerializableTime {
	private final static int LOOP_TIMES = 1000000;
	private static long step1, step2, step3;

	public static void main(String[] args) throws IOException {
		UserInfo info = new UserInfo();
		info.buildUserInfo(123456789).buildUserName("summer");

		step1 = System.currentTimeMillis();
		for (int i = 0; i < LOOP_TIMES; i++) {
			SerializeUtils.serialize(info);
		}
		step2 = System.currentTimeMillis();
		for (int i = 0; i < LOOP_TIMES; i++) {
			info.getDataByteArray();
		}
		step3 = System.currentTimeMillis();

		System.out.println("The jdk serializable time is : " + (step2 - step1) / 100 + "s");
		System.out.println("The byte arrray time is : " + (step3 - step2) / 100 + "s");
		System.out.println("The ratio is : " + ((step2 - step1) / (step3 - step2)));
	}
}
