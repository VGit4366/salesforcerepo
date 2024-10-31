#Author: your.email@your.domain.com

@regression
Feature: Login Feature

Background:
Given I landed on login page of sfdc
  
  @smoke @test
  Scenario: Validate valid login
    When I enter valid username
    And enter valid password
    And clicked on login button
    Then I should be taken to homepage
    
    @regression @test
    Scenario: Validate in-valid login
    When I enter invalid username
    And enter invalid password
    And clicked on login button
    Then I should be seeing error message

  Scenario Outline: Login to the app
    Given I want go to "<url>"
    When I enter "<username>" and "<password>"
    Then I click on the login button

    Examples: 
      | url                         | username | password  |
      |https://login.salesforce.com |    mitun | mit1234   |
      |https://login.salesforce.com |deekshith | deek1234  |
