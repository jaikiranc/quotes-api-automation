package com.hmh.favq.configuration;

public class Constants {

	public static final String CURRENT_DIR = System.getProperty("user.dir");
	static {
		if (System.getProperty("agentOS").contains("Windows"))
			FILE_SEPARATOR = System.getProperty("file.separator");
		else
			FILE_SEPARATOR = "/";
	}
	public static String FILE_SEPARATOR;
	public static final String FLAT_FILE_TARGET_DIR = System.getProperty("ffTgtDir", "C:\\Target");
	public static final String BASELINE_DIR = CURRENT_DIR + FILE_SEPARATOR + "src" + Constants.FILE_SEPARATOR + "test"
			+ Constants.FILE_SEPARATOR + "resources" + Constants.FILE_SEPARATOR + "baselines";
	public static final String EXPORT_FILE_DIR = CURRENT_DIR + FILE_SEPARATOR + "src" + Constants.FILE_SEPARATOR
			+ "main" + Constants.FILE_SEPARATOR + "resources" + Constants.FILE_SEPARATOR + "mappingtasks";
	public static final String CONFIGURATION_PATH = CURRENT_DIR + FILE_SEPARATOR + "resources" + FILE_SEPARATOR + "config";
	public static final String LINUX_HOST_CONFIGURATION_FILE=CONFIGURATION_PATH+FILE_SEPARATOR+"linux_agent_host.properties";
	public static final String ENVIRONMENT_CONFIGURATION_FILE=CONFIGURATION_PATH+FILE_SEPARATOR+"config.properties";


}
