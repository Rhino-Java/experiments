package test.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import test.example.beans.HelloWorld;

@Configuration
public class SpringConfig {

	@Bean(name = "helloBean")
	public HelloWorld helloWorld() {
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setName("Vikas Sachdeva");
		return helloWorld;
	}
}
