package test.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import test.example.beans.Scheduler;

@Configuration
public class SchedulerConfig {

	@Bean(name = "scheduler")
	public Scheduler scheduler() {
		Scheduler scheduler = new Scheduler();
		return scheduler;
	}
}
