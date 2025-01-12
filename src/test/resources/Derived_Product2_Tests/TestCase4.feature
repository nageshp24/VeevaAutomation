Feature: Derived Product 2 Tests (DP2)

  @regression
  Scenario: Validate Derived Product 2 footer links
    Given User on the DP2 home page
    When User scroll down to the footer
    Then User find all footer hyperlinks and store them in a CSV file report if any duplicate hyperlinks are present