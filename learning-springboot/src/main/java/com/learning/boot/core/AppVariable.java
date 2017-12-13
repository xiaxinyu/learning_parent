package com.learning.boot.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppVariable {
	@Value("${environment}")
	private String environment;

	@Value("${pom.properties.path}")
	private String pomPropertiesPath;

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getPomPropertiesPath() {
		return pomPropertiesPath;
	}

	public void setPomPropertiesPath(String pomPropertiesPath) {
		this.pomPropertiesPath = pomPropertiesPath;
	}
}