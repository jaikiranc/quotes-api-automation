package com.hmh.favq.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {

	private String url;
	private String loginURI;
	private String frsBaseURI;
	private String dqBaseURI;
	private String adminUserName;
	private String adminPassword;
	private static Properties properties;
	private static volatile ReadConfigFile readConfigFile;
	private static Environment environment;

	private ReadConfigFile() {
	}

	public static ReadConfigFile getInstance() {
		try {
			if (readConfigFile == null) {
				synchronized (ReadConfigFile.class) {
					if (readConfigFile == null) {
						readConfigFile = new ReadConfigFile();
						setProperties();
					}
				}
			}
			return readConfigFile;
		}catch (IOException e){
			e.printStackTrace();
			return null;
		}
	}

	private static void setProperties() throws IOException {

		FileInputStream fis = new FileInputStream(new File(Constants.ENVIRONMENT_CONFIGURATION_FILE));
		properties = new Properties();
		properties.load(fis);
		setEnvironment();
	}

	private static void setEnvironment() {
		environment = Environment.valueOf(System.getProperty("environment"));
	}

	public static Environment getEnvironment() {
		return environment;
	}

	public String getUrl() {
		return url = properties.getProperty(environment.URL).trim();
	}

	public String getLoginURI() {
		return loginURI = properties.getProperty(environment.LOGIN_URI).trim();
	}

	public String getFRSBaseURI() {
		return frsBaseURI = properties.getProperty(environment.FRSBASE_URI).trim();
	}

	public String getDQBaseURI() {
		return dqBaseURI = properties.getProperty(environment.DQBASE_URI).trim();
	}

	public String getAdminUserName() {
		return adminUserName = properties.getProperty(environment.ADMIN_USERNAME).trim();
	}

	public String getAdminPassword() {
		return adminPassword = properties.getProperty(environment.ADMIN_PASSWORD).trim();
	}
}
