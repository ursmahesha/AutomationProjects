package com.blaze.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Loads the application and environment specific config files.
 */

public class AppConfigLoader {

	/** The Base URL. */
	private String baseURL = null;

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	private static AppConfigLoader _myInstance = null;

	/**
	 * Instantiates a new app config loader.
	 */
	private AppConfigLoader() {

		Properties appConfigPropertySet = new Properties();
		try {

			// read properties file
			InputStream appConfigPropertyStream = AppConfigLoader.class
					.getResourceAsStream("/config/AppConfig.properties");
			appConfigPropertySet.load(appConfigPropertyStream);
			baseURL = appConfigPropertySet.getProperty("BASE_URL");
			appConfigPropertyStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the single instance of AppConfigLoader.
	 *
	 * @return single instance of AppConfigLoader
	 */
	public static AppConfigLoader getInstance() {
		if (_myInstance == null) {
			_myInstance = new AppConfigLoader();
		}
		return _myInstance;
	}
}
