package test.example;

import test.example.util.PropertiesCache;
import test.example.util.PropertiesConstants;

public class App {
	public static void main(String[] args) {

		System.out.println("Reading properties file...");
		String locale = PropertiesCache.getInstance().getProperty(PropertiesConstants.KEYS.LOCALE);
		System.out.println("Locale specified in properties file=" + locale);
	}
}
