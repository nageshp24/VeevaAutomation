@smoke
Feature: Core Product Tests (CP)


  Scenario: Collect all jackets' details
    Given user on the CP home page
    When user navigate to the Shop Menu and select Men's Jackets
    Then user store each Jacket Price, Title and Top Seller message to a text file
    And attach the text file to the report
