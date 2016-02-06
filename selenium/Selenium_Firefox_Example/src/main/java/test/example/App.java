package test.example;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import test.example.utility.ScreenCaptureUtil;
import test.example.utility.UiUtil;

public class App {

	private static final String BASE_URL = "http://www.google.com/?hl=en";

	private static final String TEXT_INPUT_CSS_SELECTOR = "input[type='text']";

	private static final String SEARCH_BUTTON_CSS_SELECTOR = "button[type='submit']";

	private static final String ALTERNATIVE_SEARCH_BUTTON_CSS_SELECTOR = "input[type='submit'][value='Google Search']";

	private static final String RESULT_SET_ELEMENT_ID = "resultStats";

	private static final String WIKIPEDIA_LOGO_ELEMENT_ID = "mw-wiki-logo";

	private static final String WIKIPEDIA_LINK_TEXT = "Wikipedia";

	public static void main(String[] args) throws InterruptedException, HeadlessException, IOException, AWTException {

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		ScreenCaptureUtil.getInstance().setDriver(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(BASE_URL);

		WebElement textInput = driver.findElement(By.cssSelector(TEXT_INPUT_CSS_SELECTOR));

		textInput.sendKeys("adfasdfasdfasdfadafdfadfadfasd");

		if (driver.findElements(By.cssSelector(SEARCH_BUTTON_CSS_SELECTOR)).isEmpty()) {

			driver.findElement(By.cssSelector(ALTERNATIVE_SEARCH_BUTTON_CSS_SELECTOR)).click();
		} else {
			driver.findElement(By.cssSelector(SEARCH_BUTTON_CSS_SELECTOR)).click();
		}

		if (driver.findElements(By.id(RESULT_SET_ELEMENT_ID)).isEmpty()) {
			System.out.println("No result is found");
			ScreenCaptureUtil.getInstance().captureCompletePage("./screenshots/google.png");
			driver.quit();
			return;
		}

		WebElement resultsDiv = driver.findElement(By.id(RESULT_SET_ELEMENT_ID));

		if (resultsDiv.getText().contains("About ") && resultsDiv.getText().contains(" results")) {
			String noOfResults = resultsDiv.getText().substring("About ".length(),
					resultsDiv.getText().indexOf(" results"));
			System.out.println("No of results found = " + noOfResults);
		} else if (resultsDiv.getText().contains("result")) {
			String noOfResults = resultsDiv.getText().substring(0, resultsDiv.getText().indexOf(" result"));
			System.out.println("No of result found = " + noOfResults);
		}

		ScreenCaptureUtil.getInstance().captureCompletePage("./screenshots/google.png");

		List<WebElement> wikiPediaAnchors = driver.findElements(By.partialLinkText(WIKIPEDIA_LINK_TEXT));

		if (wikiPediaAnchors.size() == 0) {
			System.out.println("There is no wikipedia page found in the search");
			driver.quit();
			return;
		}
		WebElement wikiPediaAnchor = wikiPediaAnchors.get(0);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(wikiPediaAnchor).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT)
				.build().perform();

		Thread.sleep(5000);

		UiUtil.switchToNewTab(driver);

		WebElement logoDiv = driver.findElement(By.className(WIKIPEDIA_LOGO_ELEMENT_ID));
		if (logoDiv.isDisplayed()) {
			ScreenCaptureUtil.captureCompleteScreen("./screenshots/wiki.png");
		} else {
			System.out.println("Wikipedia page is not loaded yet.");
		}
		driver.quit();
	}
}