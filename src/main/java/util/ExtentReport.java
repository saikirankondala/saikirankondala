package util;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import enums.Constants;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReport {

	private static String reportPath = System.getProperty("user.dir") + Constants.EXTENT_REPORTS_PATH.getValue()
			+ "Clucloud_Test_Automation_Report.html";

	public static ExtentReports getExtentReportsInstance() {
		return reportGenerator();
	}

	private static ExtentReports reportGenerator() {

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().enableOfflineMode(true);
		sparkReporter.config().setDocumentTitle("Clucloud Test Automation Report");
		sparkReporter.config().setEncoding("utf-8");
		sparkReporter.config().setProtocol(Protocol.HTTPS);
		sparkReporter.config().setReportName("Clucloud Test Automation Report");
		sparkReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setAnalysisStrategy(AnalysisStrategy.TEST);
		extentReports.setSystemInfo("OS",System.getProperty("os.name"));
		extentReports.setSystemInfo("OS Version",System.getProperty("os.version"));
		extentReports.setSystemInfo("OS Architecture",System.getProperty("os.arch"));
		return extentReports;
	}

	public static String getCurrentDateTime()
	{

		String pattern = "dd-MM-yyyy_HH-mm-ss";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

		return dateFormat.format(new Date());
	}

}
