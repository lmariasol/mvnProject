package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

	public static String readProperty(String key) {

		String value = "";
		try (FileInputStream input = new FileInputStream("./src/test/resources/data/configuration.properties.file")) {
			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			value = prop.getProperty(key);

		} catch (Exception e) {

		}
		return value;
	}
}
