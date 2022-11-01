package com.bdd.SpringTestAutomation.utils;

import java.io.File;
import java.time.Duration;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bdd.SpringTestAutomation.DriverProvider;

@Component
public class CommonMethods {

	@Autowired
	private DriverProvider driverProvider;
	
	@Autowired
	private ScenarioContext scenarioContext;
	
	private WebDriver driver; 
	
	@PostConstruct
	public void init() {
		driver = this.driverProvider.getDriver();
	}

	public void clickElement(WebElement element) {
		try {
			element.click();
		} catch (NoSuchElementException nse) {
			nse.printStackTrace();
			throw new RuntimeException("Element you are trying to access does not exist on the page");
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException("Error occurred while clicking a web element");
		}
	}

	public void clearTextFromInputBox(WebElement inputBoxElement) {
		try {
			inputBoxElement.clear();
		} catch (NoSuchElementException nse) {
			nse.printStackTrace();
			throw new RuntimeException("Element you are trying to access does not exist on the page");
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException("Error occurred while clearing text from a web element");
		}
	}

	public void inputText(WebElement inputBoxElement, String text) {
		try {
			clearTextFromInputBox(inputBoxElement);
			inputBoxElement.sendKeys(text);
		} catch (NoSuchElementException nse) {
			nse.printStackTrace();
			throw new RuntimeException("Element you are trying to access does not exist on the page");
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException("Error occurred while clearing text from a web element");
		}
	}

	public boolean isElementPresent(WebElement element) {
		try {
			setImplicitWait(5);
			return element.isDisplayed();
		} catch (Exception exception) {
			exception.printStackTrace();
			System.out.println("Error occurred while validating the element presence");
		} finally {
			setImplicitWait(30);
		}
		return false;
	}

	public void setImplicitWait(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException("Error occurred while setting implicit wait time");
		}
	}

	public void waitForPageToLoad() {
		try {
			String pageState = executeJavascript("document.readyState");
			while(!pageState.equalsIgnoreCase("complete"))
				Thread.sleep(1000);
		} catch (Exception exception) {
			System.out.println("Error occurred while waiting for page to load");
			exception.printStackTrace();
		}
	}

	public String executeJavascript(String script) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			return String.valueOf(jse.executeScript("return " + script));
		} catch (Exception exception) {
			System.out.println("Error occurred while executing java script");
			exception.printStackTrace();
		}
		return "";
	}
	
	public void quitDrivers() {
		driver.close();
	}
	
	public void takeScreenshot(String fileName, String path) {
		try {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(scenarioContext.getScreenshotPath() + File.separator + fileName + ".jpg");
			FileUtils.copyFile(SrcFile, DestFile);
		} catch(Exception exception) {
			exception.printStackTrace();
			System.out.println("Error occrred while taking screenshot");
		}
	}

}
