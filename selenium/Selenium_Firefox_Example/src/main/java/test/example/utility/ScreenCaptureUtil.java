package test.example.utility;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

public class ScreenCaptureUtil {

	private static ScreenCaptureUtil instance;

	private static boolean instanceCreated;

	private static WebDriver driver = null;

	private ScreenCaptureUtil() {

	}

	public static ScreenCaptureUtil getInstance() {
		if (!instanceCreated) {
			synchronized (ScreenCaptureUtil.class) {
				if (!instanceCreated) {
					instance = new ScreenCaptureUtil();
					instanceCreated = true;
				}
			}
		}
		return instance;
	}

	public void setDriver(WebDriver aDriver) {
		driver = aDriver;
	}

	public void captureCompletePage(String filePath) throws IOException {

		WebDriver tmpDriver = null;
		if (driver instanceof TakesScreenshot) {
			tmpDriver = driver;
		} else {
			tmpDriver = new Augmenter().augment(driver);
		}
		File source = ((TakesScreenshot) tmpDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(filePath));
	}

	static public void captureCompleteScreen(String filePath) throws IOException, HeadlessException, AWTException {
		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File(filePath));
	}
}