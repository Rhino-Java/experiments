package test.example.endpoint.impl;

import javax.jws.WebService;

import test.example.endpoint.HelloWorld;

//Service Implementation
@WebService(endpointInterface = "test.example.endpoint.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World - "+name.toUpperCase();
	}

}
