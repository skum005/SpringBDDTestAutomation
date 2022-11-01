package com.bdd.SpringTestAutomation.stepdefinitions;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bdd.SpringTestAutomation.DriverProvider;
import com.bdd.SpringTestAutomation.utils.ScenarioContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest
@CucumberContextConfiguration
public class Hooks {
	
	@Autowired
	private DriverProvider driverProvider;
	
	@Autowired
	private ScenarioContext scenarioContext;

	private Scenario scenario;
	private WebDriver driver = driverProvider.getDriver();
	
	public Hooks() {
		// to do
	}
	 
	@Before
	public void setUp(Scenario scenario) {
		this.scenario = scenario;
		scenarioContext.setScenarioName(trimScenarioName(this.scenario));
		createScreenshotDirectory(scenarioContext.getScenarioName());
	}
	
	@After
	public void tearDown() {
		if(scenario.isFailed()) {
			// implement code for taking screenshot when a test is failed
		}
		driver.quit();
	}
	
	private void createScreenshotDirectory(String scenarioName) {
		String directory = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + scenarioName;
		File screenshotDir = new File(directory);
		scenarioContext.setScreenshotPath(directory);
		if(!screenshotDir.exists()) {
			screenshotDir.mkdirs();
		}
	}
	
	private String trimScenarioName(Scenario scenario) {
		String scenarioName = scenario.getName();
		if(scenarioName.contains(";")) {
			scenarioName = scenarioName.split(";")[0].trim();
		}
		if(scenarioName.length() > 15)
			scenarioName = scenarioName.substring(0,14);
		return scenarioName;
	}
	
}
