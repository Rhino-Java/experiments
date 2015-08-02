package test.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class App {
	public static void main(String[] args) {
		Date today = new Date();
		SimpleDateFormat englishDateFormat = new SimpleDateFormat("EEEE dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
		/**
		 * Here 'EEEE' represents complete name of the day of the week like
		 * Thursday. However, only 'E' represents short name of the day of the
		 * week.
		 */
		System.out.println("Today's date in english locale and system timezone- " + englishDateFormat.format(today));

		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd MMM yyyy HH:mm:ss z", Locale.JAPANESE);

		String japaneseDate = dateFormat.format(today);
		System.out.println("Today's date in japanese locale and system timezone- " + japaneseDate);

		dateFormat.setTimeZone(TimeZone.getTimeZone("JST"));
		japaneseDate = dateFormat.format(today);
		System.out.println("Today's date in japanese locale and japanese timezone- " + japaneseDate);
	}
}