package com.bdd.SpringTestAutomation;

import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bdd.SpringTestAutomation.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

@Component
public class DriverProvider {

	@Autowired
	ConfigReader configReader;

	private WebDriver driver;
	private DesiredCapabilities capabilities;
	
	@PostConstruct
	public void init() {
		if(this.configReader.getLocation().equalsIgnoreCase("remote")) {
			setRemoteDriver();
		} else {
			setLocalDriver();
		}
	}

	public void setLocalDriver() {
		switch (configReader.getBrowser().toUpperCase()) {
			case "CHROME": {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}
			case "FIREFOX": {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			}
		}
	}

	public void setRemoteDriver() {
		capabilities = new DesiredCapabilities();
		try {
			driver = new RemoteWebDriver(new URL(configReader.getGridURL()), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
