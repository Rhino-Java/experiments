package test.example;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import test.example.endpoint.HelloWorld;

public class App {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:9999/ws/hello?wsdl");

		/**
		 * <pre>
		 * Following method takes two arguments -
		 * 
		 * 1. Namespace URI - value of targetNamespace attribute of definitions element in above WSDL document 
		 * 2. Local part - value of name attribute of definitions element in above WSDL
		 * document.
		 * 
		 * </pre>
		 */
		QName qname = new QName("http://impl.endpoint.example.test/",
				"HelloWorldImplService");

		Service service = Service.create(url, qname);

		HelloWorld hello = service.getPort(HelloWorld.class);

		System.out.println(hello.getHelloWorldAsString("vikas"));
	}
}