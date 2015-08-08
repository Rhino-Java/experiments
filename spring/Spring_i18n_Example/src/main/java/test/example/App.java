package test.example;

import java.util.Locale;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import test.example.config.AppConfig;

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		printEnglishLocaleMessages(context);
		printJapaneseLocaleMessages(context);
		printOtherLocaleMessages(context);

		context.close();
	}

	private static void printOtherLocaleMessages(
			AbstractApplicationContext context) {
		System.out.println("\nMessages in Canada Locale-");
		/*
		 * If the properties file corresponding to other locale (Canada) is not
		 * present, then system locale (English) will be used for identifying
		 * the properties file. If the properties file corresponding to system
		 * locale (English) is not present (message_en.properties), then default
		 * properties file (message.properties) is used.
		 */
		String msg = context.getMessage("msg1", new Object[] {}, Locale.CANADA);
		System.out.println(msg);
		msg = context.getMessage("msg2", new Object[] {}, Locale.CANADA);
		System.out.println(msg);
		msg = context.getMessage("msg3", new Object[] {}, Locale.CANADA);
		System.out.println(msg);
		msg = context.getMessage("msg", new Object[] { "test" }, Locale.CANADA);
		System.out.println(msg);
	}

	private static void printJapaneseLocaleMessages(
			AbstractApplicationContext context) {
		System.out.println("\nMessages in Japanese Locale-");
		String msg = context.getMessage("msg1", new Object[] {},
				Locale.JAPANESE);
		System.out.println(msg);
		msg = context.getMessage("msg2", new Object[] {}, Locale.JAPANESE);
		System.out.println(msg);
		msg = context.getMessage("msg3", new Object[] {}, Locale.JAPANESE);
		System.out.println(msg);
		msg = context.getMessage("msg", new Object[] { "test" },
				Locale.JAPANESE);
		System.out.println(msg);
	}

	private static void printEnglishLocaleMessages(
			AbstractApplicationContext context) {
		System.out.println("\nMessages in English Locale-");
		String msg = context
				.getMessage("msg1", new Object[] {}, Locale.ENGLISH);
		System.out.println(msg);
		msg = context.getMessage("msg2", new Object[] {}, Locale.ENGLISH);
		System.out.println(msg);
		msg = context.getMessage("msg3", new Object[] {}, Locale.ENGLISH);
		System.out.println(msg);
		msg = context
				.getMessage("msg", new Object[] { "test" }, Locale.ENGLISH);
		System.out.println(msg);
	}
}
