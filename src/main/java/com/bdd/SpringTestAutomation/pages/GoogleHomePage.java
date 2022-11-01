package com.bdd.SpringTestAutomation.pages;

import javax.annotation.PostConstruct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bdd.SpringTestAutomation.DriverProvider;
import com.bdd.SpringTestAutomation.utils.CommonMethods;

@Component
public class GoogleHomePage extends CommonMethods {
	
	@Autowired
	private DriverProvider driverProvider;
	
	private WebDriver driver;

	@PostConstruct
	public void init() {
		driver = driverProvider.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[name='q']")
	private WebElement searchBox;
	
	@FindBy(xpath = "(//input[@value='Google Search'])[2]")
	private WebElement searchButton;
	
	@FindBy(css = "img[alt='Google']")
	private WebElement googleMainBodyImage;

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}	
	
	public WebElement getGoogleMainBodyImage() {
		return googleMainBodyImage;
	}	
	
	public void search(String searchTerm) {
		inputText(getSearchBox(), searchTerm);
		clickElement(getSearchBox());
	}
	
	public boolean isHomePage() {
		return isElementPresent(getGoogleMainBodyImage());
	}
	
	
}
