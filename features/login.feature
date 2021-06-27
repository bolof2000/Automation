Feature: Login to internet website

  Scenario Outline: valid and invalid login tests
    Given I am on the homepage
    When I click on the form Authentication link
    And I enter the username as "<username>" and password as "<password>"
    Then verify the I am on the secure page area

    Examples:
      | username  | password   |  |
      | bolof2000 | test       |  |
      | tomsmith  | superscret |  |
