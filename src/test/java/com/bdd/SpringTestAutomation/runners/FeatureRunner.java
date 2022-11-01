package com.bdd.SpringTestAutomation.runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "classpath:src/test/resources/features", 
				 glue = {"com.bdd.SpringTestAutomation.stepdefinitions"}, 
				 plugin = {"pretty", "html:target/cucumber-html", "json:target/cucumber-report.json"},
				 tags = "@search")
public class FeatureRunner extends AbstractTestNGCucumberTests {

	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }	
	
}
