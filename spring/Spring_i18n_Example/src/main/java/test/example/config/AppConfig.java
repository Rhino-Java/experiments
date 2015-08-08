package test.example.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages/message");
		return messageSource;
	}
	/**
	 * Following is XML configuration -
	 * 
	 * <pre>
	 * 		<bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
	 * 			<property name="basename" value="messages/message"></property> 
	 * 		</bean>
	 * </pre>
	 */
}
