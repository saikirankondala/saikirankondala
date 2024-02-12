package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * PropertyLoader -- Class for accessing values from .properties file
 */
public class PropertyLoader {

	private Properties properties;

	/**
	 * This method returns properties from user identified .properties file
	 * 
	 * @param filename (String, name of the .properties file)
	 * @param variable (String, name of the variable from .properties file)
	 * 
	 * @return Returns value of the variable from .properties file
	 */
	public String getValue(String filename, String variable) {

		try {

			String path = System.getProperty("user.dir") + "/";
			File file = new File(path + filename);
			FileInputStream fileInput = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInput);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Could not get Properties from the .properties file");
		}
		return properties.getProperty(variable);
	}

}
