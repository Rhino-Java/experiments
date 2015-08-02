package test.example;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		configureLog4j();
		for (int i = 0; i < 10; i++)
			if (i % 2 == 0)
				LOGGER.info("Hello {} !!! How are you ?", i);
			else
				LOGGER.warn("It is {} index", i);
	}

	private static void configureLog4j() {
		/*
		 * DOMConfigurator is used to configure logger from xml configuration
		 * file
		 */

		DOMConfigurator.configure("log_config/log4j.xml");

	}
}
