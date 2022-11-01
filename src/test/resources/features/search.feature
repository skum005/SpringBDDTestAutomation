@search @smoke
Feature: As a user I should be able to search and get valid results by google

  Background: Search for different items in google and validate the results

  @search1
  Scenario: Search1;Validate search functionality with basic search
    Given User is on google home page
    When User searches for "selenium bdd framework"
	  #Then valid search results should be displayed
	  #And User should be able to see pagination
	  #And User should be able to see another search box
 
  @search2
  Scenario: Search2;Validate search functionality with basic search
    Given User is on google home page
    When User searches for "Johnny Depp"

  @search3
  Scenario: Search3;Validate search functionality with basic search
    Given User is on google home page
    When User searches for "Camile V"
