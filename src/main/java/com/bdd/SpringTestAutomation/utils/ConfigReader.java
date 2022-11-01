package com.bdd.SpringTestAutomation.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigReader {

	@Value("${browser:chrome}")
	private String browser;

	@Value("${appURL}")
	private String appURL;

	@Value("${gridURL}")
	private String gridURL;
	
	@Value("${environment}")
	private String environment;
	
	@Value("${location}")
	private String location;
	
	@Value("${screenshotPath}")
	private String screenshotPath;
	
	@Value("${screenshotFlag}")
	private String screenshotFlag;

	public String getBrowser() {
		return browser;
	}

	public String getAppURL() {
		return appURL;
	}

	public String getGridURL() {
		return gridURL;
	}

	public String getEnvironment() {
		return environment;
	}

	public String getLocation() {
		return location;
	}

	public String getScreenshotFlag() {
		return screenshotFlag;
	}
	
	public static ConfigReader getInstance() {
		return new ConfigReader();
	}

}
