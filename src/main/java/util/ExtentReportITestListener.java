package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import enums.Constants;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class ExtentReportITestListener implements ITestListener {

	protected String iTestContext;

	private Base baseInstance = Base.getInstance();
	private static ExtentReports extent = ExtentReport.getExtentReportsInstance();

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	@AfterSuite ()
	public void onFinish(ITestContext iTestContext) {
		extent.flush();
		extentTest.remove();
		if (Base.getDriver() != null) {
			try {
				baseInstance.tearDown();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Parameters({ "browser" })
	@BeforeMethod
	protected synchronized void beforeMethod(String browser, Method method, ITestContext iTestContext) throws IOException {
		File directory = new File(System.getProperty("user.dir") + Constants.DOWBLOADED_FILE.getValue());
		FileUtils.cleanDirectory(directory);
		baseInstance.setUp(browser);
		// This will get the name from the @Test(testName annotation) and sets it as
		// Test node

		String testName = method.getAnnotation(Test.class).testName();

		if (testName == null || testName.isEmpty()) {
			// If the testName is not provided, then the code just gets the method name and
			// sets it as Test node
			testName = method.getName();
		}
		ExtentTest et = extent.createTest(testName).assignDevice(iTestContext.getName());
		extentTest.set(et);
	}

	@AfterMethod()
	protected synchronized void afterMethod(ITestResult result) throws IOException {
		String callingMethodName = result.getMethod().getMethodName();

		if (result.getStatus() == ITestResult.SUCCESS) {

			String logText = "<b>" + "PASSED" + "</b>";

			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);

			long timeTaken = result.getEndMillis() - result.getStartMillis();
			String message = "Time taken: " + timeTaken + " milliseconds";

			getExtentTestName().get().log(Status.PASS, message).pass(m.getMarkup(),
					MediaEntityBuilder
							.createScreenCaptureFromBase64String(
									ScreenshotCapture.getBase64Screenshot(Base.getDriver(), callingMethodName))
							.build());

		} else if (result.getStatus() == ITestResult.SKIP) {
			String logText = "<b>" + "SKIPPED" + "</b>";

			Markup m = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
			getExtentTestName().get().skip(m);

			long timeTaken = result.getEndMillis() - result.getStartMillis();

			String message = "Time taken: " + timeTaken + " milliseconds";

			getExtentTestName().get().log(Status.SKIP, message).skip(m.getMarkup(),
					MediaEntityBuilder
							.createScreenCaptureFromBase64String(
									ScreenshotCapture.getBase64Screenshot(Base.getDriver(), callingMethodName))
							.build());

		} else {
			String logText = "<b>" + "FAILED" + "</b>";

			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);

			long timeTaken = result.getEndMillis() - result.getStartMillis();
			String exceptionMessage = result.getThrowable().getMessage();

			getExtentTestName().get().fail(m.getMarkup(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(
							ScreenshotCapture.getBase64Screenshot(Base.getDriver(), callingMethodName)).build())
					.log(Status.FAIL,
							"<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Cause of Failure: " + "</b>"
									+ "Click to see" + "</font>" + "</summary>"
									+ exceptionMessage.replaceAll(",", "<br>") + "</details>" + "Time taken: "
									+ timeTaken + " milliseconds");

			// String[] exceptionMessageArray = exceptionMessage.split("Build info");

		}
		baseInstance.tearDown();
	}

	public static ExtentTest test() {
		return extentTest.get();
	}

	/**
	 * @return the grandchildExtentTest
	 */
	public static ThreadLocal<ExtentTest> getExtentTestName() {
		return extentTest;
	}

	// @AfterSuite ()
	/*public void reportScreenshot() throws IOException, InterruptedException {
		ExtentReportScreenshot extentReport = new ExtentReportScreenshot();
		extentReport.takeReportScreenshot();
//	}*/
}
