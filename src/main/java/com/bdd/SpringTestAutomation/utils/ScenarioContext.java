package com.bdd.SpringTestAutomation.utils;

import org.springframework.stereotype.Component;

@Component
public class ScenarioContext {
	
	private String scenarioName;
	private String screenshotPath;

	public String getScenarioName() {
		return scenarioName;
	}

	public void setScenarioName(String scenarioName) {
		this.scenarioName = scenarioName;
	}

	public String getScreenshotPath() {
		return screenshotPath;
	}

	public void setScreenshotPath(String screenshotPath) {
		this.screenshotPath = screenshotPath;
	}
	
}
