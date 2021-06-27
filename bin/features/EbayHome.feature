Feature: Ebay Home Page features

  @Test001
  Scenario: Advanced search on ebay home
    Given I am on ebay Home page
    When I click advanced search
    Then verify I am navigated to the next page
    And verify the new url

    @Test002
    Scenario: Ebay Logo on advanced Search Page
      Given I am on Ebay Advanced search page
      When I click on Ebay Logo
      Then I am navigated to Ebay Home Page