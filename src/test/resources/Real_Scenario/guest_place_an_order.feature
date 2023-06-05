@dummyFeatures
Feature: Place an Order
  Rule: Place an Order

  Scenario Outline: Using default payment option

    Given I'm a customer
    And I have <quantity> "<product_name>" in the cart
    And I'm on the checkout page
    When I provide billing details

      |first_name|last_name|country   |street      |town |state |zip |phone      |email             |
      |Mustafizur|Rahman   |Bangladesh|Narayanganj |Dhaka|Dhaka |1250|01686026037|mustafiz@gmail.com|

    And I place an order
    Then The order should be placed successfully

    Examples:
    |product_name|quantity|
    |Blue Shoes  |1       |


