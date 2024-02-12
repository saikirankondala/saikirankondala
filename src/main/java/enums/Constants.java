package enums;

import java.io.File;

import util.PropertyLoader;

public enum Constants {

	// Properties file
	CONFIG_FILE("src" + File.separator + "resources" + File.separator + "properties"
			+ File.separator + "config.properties"),
	DOWBLOADED_FILE( File.separator + "src"+ File.separator +"file_download"),
	MAX_WAIT(""), 
	POLLING_TIME(""), 
	WEBDRIVER_DEFAULT_WAIT(""),
	TEST_URL(""),
	EXTENT_REPORTS_PATH(""), 
	SCREENSHOTS_PATH(""), 
	EXTENT_REPORT_SCREENSHOT_PATH(""), 
	NHM_TEST_URL(""), 
	DB_HOST(""),
	WEBLCT_TEST_URL("");

	private String constantVariables;

	private Constants(String constantVariables) {
		this.constantVariables = constantVariables;
	}

	public String getValue() {
		return this.constantVariables;
	}

	static {

		try {

			String propFile = Constants.CONFIG_FILE.getValue();
			PropertyLoader propLoader = new PropertyLoader();
			Constants.WEBDRIVER_DEFAULT_WAIT.constantVariables = propLoader.getValue(propFile,
					"webdriver.default.wait");
			Constants.MAX_WAIT.constantVariables = propLoader.getValue(propFile, "max.wait");
			Constants.POLLING_TIME.constantVariables = propLoader.getValue(propFile, "polling.time");
			Constants.TEST_URL.constantVariables = propLoader.getValue(propFile, "nms.test.url");
			Constants.EXTENT_REPORTS_PATH.constantVariables = propLoader.getValue(propFile, "extent.reports.path");
			Constants.SCREENSHOTS_PATH.constantVariables = propLoader.getValue(propFile, "screenshots.path");
			Constants.EXTENT_REPORT_SCREENSHOT_PATH.constantVariables = propLoader.getValue(propFile,
					"report.screenshot.path");		
			Constants.NHM_TEST_URL.constantVariables = propLoader.getValue(propFile, "nhm.test.url");			
			Constants.DB_HOST.constantVariables = propLoader.getValue(propFile, "db.host");
			Constants.WEBLCT_TEST_URL.constantVariables = propLoader.getValue(propFile, "weblct.test.url");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
