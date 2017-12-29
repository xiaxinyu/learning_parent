package org.learning.design.pattern.observer;

import org.junit.Test;
import org.learning.design.pattern.observer.SummerObserver;
import org.learning.design.pattern.observer.WeatherObserverable;
import org.learning.design.pattern.observer.WinnerObserver;

public class ObserverTest {
	@Test
	public void testObserver() {
		WeatherObserverable observable = new WeatherObserverable();
		observable.addObserver(new SummerObserver());
		observable.addObserver(new WinnerObserver());
		observable.setWeather("cloudy");
		observable.setWeather("rainy");
	}
}
