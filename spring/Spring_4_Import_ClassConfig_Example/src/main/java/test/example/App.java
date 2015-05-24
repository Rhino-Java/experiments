package test.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import test.example.beans.Customer;
import test.example.beans.Scheduler;
import test.example.config.SpringConfig;

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				SpringConfig.class);

		Customer customer = (Customer) context.getBean("customer");
		customer.printMsg("Hello Customer");

		Scheduler scheduler = (Scheduler) context.getBean("scheduler");
		scheduler.printMsg("Hello Scheduler");

		context.close();
	}
}
