Feature: Registration and Login

  As a customer of AskOmDch app, I should be able to go to the AskOmDch home page,
  then I want to go to Account page, so that I can open an account and login.

  Background: Common Steps
    Given I'm a customer
    And I'm on the Account Page

  Scenario: Registration

    Then I fill up my information
    And Registration should be successful and I should see my username

  Scenario Outline: Login

    Then I enter my login credentials from given sheetname "<SheetName>" and rownumber <RowNumber>
    And Login should be successful and username should be visible from given sheetname "<SheetName>" and rownumber <RowNumber>

    Examples:
      |   SheetName  |RowNumber|
      | Registration |    0    |