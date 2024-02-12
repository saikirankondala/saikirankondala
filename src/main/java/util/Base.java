package util;

import enums.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Base {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	String downloadFilepath = System.getProperty("user.dir") + Constants.DOWBLOADED_FILE.getValue();

	public static Base getInstance() {
		return new Base();
	}

	protected final void setDriver(String browser) {

		switch (browser.toUpperCase()) {

			case "CHROME":
				WebDriverManager.chromedriver().setup();
				driver.set(new ChromeDriver(chromeOptions()));


				break;

			case "FIREFOX":
				WebDriverManager.firefoxdriver().setup();
				driver.set(new FirefoxDriver(firefoxOptions()));
				break;

			case "EDGE":
				WebDriverManager.edgedriver().setup();
				driver.set(new EdgeDriver(edgeOptions()));
				break;
		}
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	protected void setUp(String browser) {
		setDriver(browser);
		int defaultWebdriverWait = Integer.parseInt(Constants.WEBDRIVER_DEFAULT_WAIT.getValue());
		getDriver().manage().timeouts().implicitlyWait(defaultWebdriverWait, TimeUnit.MILLISECONDS);

	}

	private ChromeOptions chromeOptions() {
		// Setup Chrome environment:
		ChromeOptions chromeOptions = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		chromeOptions.addArguments("--remote-allow-origins=*");
		chromeOptions.addArguments("disable-features=DownloadUI");
//		chromeOptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, true);
		chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		chromeOptions.setHeadless(false);
		chromeOptions.addArguments("--enable-notifications");
        return chromeOptions;
    }

		///
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		Map<String, Object> profile = new HashMap<String, Object>();
//		Map<String, Object> contentSettings = new HashMap<String, Object>();
//
//		// SET CHROME OPTIONS
//		// 0 - Default, 1 - Allow, 2 - Block
//		contentSettings.put("notifications", 1);
//		profile.put("managed_default_content_settings", contentSettings);
//		prefs.put("profile", profile);
//		chromeOptions.setExperimentalOption("prefs", prefs);

		// SET CAPABILITY
//		caps.setCapability(ChromeOptions.CAPABILITY, options);

//		WebDriver driver = new RemoteWebDriver(new URL(URL), caps)
		///
//		chromeOptions.addArguments("--start-maximized");
//		chromeOptions.addArguments("window-size=1380,800");
//		return chromeOptions;


	private FirefoxOptions firefoxOptions() {

		// Setup Firefox Environment
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		//firefoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		firefoxOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		firefoxOptions.setHeadless(true);
		firefoxOptions.addArguments("--window-size=700,700");

		return firefoxOptions;
	}

	private EdgeOptions edgeOptions() {

		// Setup Edge Environment
		EdgeOptions edgeOptions = new EdgeOptions();
		//edgeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		edgeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		edgeOptions.addArguments("headless");
		edgeOptions.addArguments("--window-size=1380,800");

		return edgeOptions;
	}

	protected void tearDown() {

		if (driver != null) {
			getDriver().quit();
		}
	}
}
