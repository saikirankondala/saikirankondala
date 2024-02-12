package enums;

import java.io.File;

import util.PropertyLoader;

public enum TestData {

	// Properties file
	TESTDATA_FILE("src" + File.separator + "resources" + File.separator + "properties"
			+ File.separator + "testData.properties"),

	USERNAME(""), PASSWORD(""), INVALID_PASSWORD(""), PTP_COLUMNS(""), SETS_COLUMNS(""), NHM_PASSWORD(""), NHM_USERNAME(""),DB_NAME(""),
	DB_USER(""), DB_PASS(""), ID_Clu("");

	private String testDataVariables;

	private TestData(String testDataVariables) {
		this.testDataVariables = testDataVariables;
	}

	public String getValue() {
		return this.testDataVariables;
	}

	static {

		try {
			String propFile = TestData.TESTDATA_FILE.getValue();
			PropertyLoader propLoader = new PropertyLoader();
			TestData.USERNAME.testDataVariables = propLoader.getValue(propFile, "login.username");		
			TestData.PASSWORD.testDataVariables = propLoader.getValue(propFile, "login.password");
			TestData.NHM_USERNAME.testDataVariables = propLoader.getValue(propFile, "login.username.nhm");
			TestData.NHM_PASSWORD.testDataVariables = propLoader.getValue(propFile, "login.password.nhm");

			TestData.INVALID_PASSWORD.testDataVariables = propLoader.getValue(propFile, "login.invalid.password");
			TestData.PTP_COLUMNS.testDataVariables = propLoader.getValue(propFile, "ptp.columns");
			TestData.SETS_COLUMNS.testDataVariables = propLoader.getValue(propFile, "sets.columns");
			TestData.DB_NAME.testDataVariables = propLoader.getValue(propFile, "dbName");
			TestData.DB_USER.testDataVariables = propLoader.getValue(propFile, "db.user");
			TestData.DB_PASS.testDataVariables = propLoader.getValue(propFile, "db.pass");
			TestData.ID_Clu.testDataVariables = propLoader.getValue(propFile, "login.Id");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
