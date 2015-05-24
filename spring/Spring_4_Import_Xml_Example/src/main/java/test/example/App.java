package test.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.example.beans.Customer;
import test.example.beans.Scheduler;

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Config.xml");

		Customer customer = (Customer) context.getBean("customer");
		customer.printMsg("Hello Customer");

		Scheduler scheduler = (Scheduler) context.getBean("scheduler");
		scheduler.printMsg("Hello Scheduler");

		context.close();
	}
}