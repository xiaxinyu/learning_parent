package org.learning.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class StreamTest {
	public List<Apple> productApples() {
		Random colorR = new Random();
		Random weightR = new Random();

		List<Apple> apples = new ArrayList<Apple>();
		int color;
		float weight;
		String strColor = "Red";

		for (int i = 0; i < 40000000; i++) {
			color = colorR.nextInt(3);
			weight = weightR.nextInt(10);

			switch (color) {
			case 0:
				strColor = "Red";
				break;
			case 1:
				strColor = "Green";
				break;
			case 2:
				strColor = "White";
				break;
			default:
				strColor = "Red";
			}

			apples.add(new Apple(strColor, (weight <= 0 ? 1 : weight) * 100));
		}

		return apples;
	}

	public static void main(String[] args) throws InterruptedException {
		StreamTest test = new StreamTest();
		List<Apple> apples = test.productApples();
		
		List<Apple> applesGt150 = apples.stream().filter((Apple a) -> a.getWeight() > 150).collect(toList());
		List<Apple> applesLt150 = apples.stream().filter((Apple a) -> a.getWeight() < 150).collect(toList());

		System.out.println(applesGt150.size() + " " + applesLt150.size());
		
		Thread.sleep(100000);
	}
}
