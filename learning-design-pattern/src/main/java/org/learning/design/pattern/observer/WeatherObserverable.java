package org.learning.design.pattern.observer;

public class WeatherObserverable extends Observable {
	private String weather;

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		if (this.observers != null && this.observers.size() > 0) {
			for (Observer observer : this.observers) {
				observer.update(this.weather, weather);
			}
		}
		this.weather = weather;
	}
}
