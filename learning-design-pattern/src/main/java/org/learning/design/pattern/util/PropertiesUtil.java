package org.learning.design.pattern.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties properties;
	static {
		InputStream inputStream = null;
		try {
			inputStream = ClassLoader.getSystemResourceAsStream("factory.properties");
			properties = new Properties();
			properties.load(inputStream);
		} catch (IOException e) {
			properties = null;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
				}
			}
		}
	}

	public static String getValue(String key) {
		return properties.getProperty(key);
	}
}
