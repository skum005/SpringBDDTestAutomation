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
public class SearchResultsPage extends CommonMethods {
	
	@Autowired
	private DriverProvider driverProvider;
	
	private WebDriver driver;

	@PostConstruct
	public void init() {
		driver = driverProvider.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div#hdtb-msb-vis div.hdtb-msel")
	private WebElement headerLinkAll;
	
	@FindBy(css = "div#hdtb-msb-vis div.hdtb-msel+div a")
	private WebElement headerLinkVideos;

	public WebElement getHeaderLinkAll() {
		return headerLinkAll;
	}

	public WebElement getHeaderLinkVideos() {
		return headerLinkVideos;
	}
	
	public void clickVideos() {
		
	}
}
