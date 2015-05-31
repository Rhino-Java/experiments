package test.example;

import test.example.endpoint.impl.HelloWorld;
import test.example.endpoint.impl.HelloWorldImplService;

/**
 * 
 * <pre>
 * 
 * Use following command for generating web service client using wsimport tool -
 * 
 * wsimport -keep http://localhost:9999/ws/hello?wsdl
 * 
 * wsimport tool is bundle with the JDK.
 * 
 * In this case, it will generate test.example.endpoint.impl package which contains two files -
 * 
 * 1. HelloWorld.java
 * 2. HelloWorldServiceImplService.java
 * 
 * </pre>
 * 
 */
public class App {
	public static void main(String[] args) {
		HelloWorldImplService helloService = new HelloWorldImplService();
		HelloWorld hello = helloService.getHelloWorldImplPort();

		System.out.println(hello.getHelloWorldAsString("vikas sachdeva"));
	}
}
