package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import enums.Constants;

public class ScreenshotCapture {

	private static String screenshotFolder = System.getProperty("user.dir") + Constants.SCREENSHOTS_PATH.getValue();

	public static String getBase64Screenshot(WebDriver driver, String screengrabName) throws IOException {

		String base64StringofScreenshot = "";

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String dest = screenshotFolder + getCurrentDateTime() + "_" + screengrabName + ".png";

		File destination = new File(dest);
		FileUtils.copyFile(source, destination);

		byte[] fileContent = FileUtils.readFileToByteArray(source);
		base64StringofScreenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
		return base64StringofScreenshot;
	}

	public static String getCurrentDateTime() {

		String pattern = "dd-MM-yyyy_HH-mm-ss";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(new Date());
	}

}
