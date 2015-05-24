package test.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import test.example.beans.Customer;

@Configuration
public class CustomerConfig {

	@Bean(name = "customer")
	public Customer customer() {
		Customer customer = new Customer();
		return customer;
	}
}
