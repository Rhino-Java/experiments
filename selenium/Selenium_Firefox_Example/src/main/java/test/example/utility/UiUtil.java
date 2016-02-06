package test.example.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class UiUtil {

	public static void switchToNewTab(WebDriver driver) {
		Set<String> windowSet = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(windowSet);
		String newTab = windowList.get(windowList.size() - 1);
		driver.switchTo().window(newTab); // switch to new tab
	}

	public static void closeCurrentTabAndSwitchToNewTab(WebDriver driver) {
		Set<String> windowSet = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(windowSet);
		String newTab = windowList.get(windowList.size() - 1);
		driver.close(); // close the original tab
		driver.switchTo().window(newTab); // switch to new tab
	}
}
