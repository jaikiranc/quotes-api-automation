package com.hmh.favq.configuration;

public enum Environment {

	DOCKER("DOCKER"), QAPOD("QAPOD"), STAGE6("STAGE6"), STAGE5("STAGE5"), SANDBOX("SANDBOX"),UPGRADE_POD("UPGRADE_POD"),DEVPOD("DEVPOD"),R33AWS("R33AWS"),
	CP_QAPOD("CP_QAPOD"),CP_DEVPOD("CP_DEVPOD"),CP_R33AWS("CP_R33AWS"),CP_R33AWS_LINUX("CP_R33AWS_LINUX"),UPGRADE("UPGRADE"),UPGRADE_STAGING_POD("UPGRADE_STAGING_POD"),
	UPGRADE_EMEA_POD("UPGRADE_EMEA_POD"),UPGRADE_US_POD("UPGRADE_US_POD"),PERFPOD("PERFPOD"),DEV_ML_POD("DEV_ML_POD");

	Environment(String env) {
		this.setEnv(env);
		this.URL = this.getEnv() + "_URL";
		this.LOGIN_URI = this.getEnv() + "_LOGIN_URI";
		this.FRSBASE_URI = this.getEnv() + "_FRSBASE_URI";
		this.DQBASE_URI = this.getEnv() + "_DQBASE_URI";
		this.ADMIN_USERNAME = this.getEnv() + "_ADMIN_USERNAME";
		this.ADMIN_PASSWORD = this.getEnv() + "_ADMIN_PASSWORD";
	}

	public String getEnv() {
		return env;
	}

	private void setEnv(String env) {
		this.env = env;
	}

	private String env;
	final String URL;
	final String LOGIN_URI;
	final String FRSBASE_URI;
	final String DQBASE_URI;
	final String ADMIN_USERNAME;
	final String ADMIN_PASSWORD;

}
