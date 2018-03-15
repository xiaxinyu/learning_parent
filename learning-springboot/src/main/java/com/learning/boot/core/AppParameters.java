package com.learning.boot.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class AppParameters {
	@Value("${app.environment}")
	private String environment;

	@Value("${app.pom-path}")
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