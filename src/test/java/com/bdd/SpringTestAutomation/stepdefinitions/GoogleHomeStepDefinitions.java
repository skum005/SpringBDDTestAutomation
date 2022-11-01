package com.bdd.SpringTestAutomation.stepdefinitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bdd.SpringTestAutomation.DriverProvider;
import com.bdd.SpringTestAutomation.SpringTestAutomationApplication;
import com.bdd.SpringTestAutomation.pages.GoogleHomePage;
import com.bdd.SpringTestAutomation.pages.SearchResultsPage;
import com.bdd.SpringTestAutomation.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest
//(classes = SpringTestAutomationApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoogleHomeStepDefinitions {
	
	ConfigReader configReader = ConfigReader.getInstance();
	
	@Autowired
	DriverProvider driverProvider;
	
	@Autowired
	GoogleHomePage googleHome;
	
	@Autowired
	SearchResultsPage searchResultsPage;
	
	public GoogleHomeStepDefinitions() {
		// to do
	}

	@Given("User is on google home page")
	public void openHomePage() {
		try {
			driverProvider.getDriver().get(configReader.getAppURL());
		} catch(Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException("Error occurred while trying to launch application");
		}
		googleHome.isHomePage();
		googleHome.takeScreenshot("HomePage","");
	}
	
	@When("User searches for {string}")
	public void searchInGoogleHomePage(String searchTerm) {
		googleHome.search(searchTerm);
		googleHome.takeScreenshot("SearchResults", "");
	}
	
}
