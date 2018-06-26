package org.learning.concurrent.random.number;

import java.util.Random;

public class RandomNumber {
	public static Integer getRandomNumber() {
		int min = 5000, max = 9000;
		Random random = new Random();
		int rn = random.nextInt(max - min);
		if (rn == 0) {
			return min;
		} else {
			return min + rn + 1;
		}
	}
}
