package test.example;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class MyApplication extends ResourceConfig {

	public MyApplication() {

		// Turn on Jersery classpath scanning for web service classes
		// (resources)
		packages("test.example.resources");

		// Jackson JSON marshalling
		register(JacksonFeature.class);
	}
}
