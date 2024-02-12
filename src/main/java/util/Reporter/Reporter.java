package util.Reporter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import util.Formatter;

public class Reporter {

	/**
	 * The method writes messages to the log
	 * 
	 * @param s
	 */
	public static void log(String s) {
		log(s, true);
	}

	/**
	 * The method writes messages to the log
	 * 
	 * @param s
	 * @param printConsole
	 */
	public static void log(String s, boolean printConsole) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("H:mm:ss:SSS");
		sdf.format(cal.getTime());

		org.testng.Reporter.log("[" + sdf.format(cal.getTime()) + "]: " + Formatter.escapeCharacters(s));

		if (printConsole)
			System.out.println("[" + sdf.format(cal.getTime()) + "]: " + s);
	}

}
