@dummyFeatures
Feature: Add to cart
  Rule: Add from Store

    Background:
      Given I'm on the Store Page

  @scenario1
  Scenario Outline: Add one quantity to the cart

    When I add a "<product_name>" to the cart
    Then I see <quantity> "<product_name>" in the cart

    Examples:
    |product_name|quantity|
    |Blue Shoes  |1       |

    @scenario2
    Scenario Outline: Add one quantity to the cart

      When I add a "<product_name>" to the cart
      Then I see <quantity> "<product_name>" in the cart

      Examples:
        |product_name|quantity|
        |Red Shoes   |1       |


