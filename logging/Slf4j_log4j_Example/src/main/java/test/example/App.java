package test.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

	/**
	 * Name of the log configuration file must be log4j.xml or log4j.properties
	 * and It should be present in the classpath of the program.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++)
			if (i % 2 == 0)
				LOGGER.info("Hello {} !!! How are you ?", i);
			else
				LOGGER.warn("It is {} index", i);
	}
}
