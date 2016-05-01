package test.example.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesCache {

	private final Properties properties = new Properties();

	private PropertiesCache() {
		try {
			InputStream inputStream = new FileInputStream(PropertiesConstants.FILE_PATH);
			properties.load(inputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static class ClassLazyHolder {
		private static final PropertiesCache INSTANCE = new PropertiesCache();
	}

	public static PropertiesCache getInstance() {
		return ClassLazyHolder.INSTANCE;
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public String getProperty(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public Set<String> getAllPropertyNames() {
		return properties.stringPropertyNames();
	}

	public boolean containsKey(String key) {
		return properties.containsKey(key);
	}
}