@dummyFeatures
Feature: Add to cart
  Rule: Add from Store

  @Sanity
  Scenario Outline: Add one quantity to the cart
    Given I'm on the Store Page
    When I add a "<product_name>" to the cart
    Then I see <quantity> "<product_name>" in the cart

    Examples:
    |product_name|quantity|
    |Blue Shoes  |1       |

    @Regression
    Scenario Outline: Add two quantity to the cart
      Given I'm on the Store Page
      When I add a "<product_name>" to the cart
      Then I see <quantity> "<product_name>" in the cart

      Examples:
        |product_name |quantity|
        |Green Shoes  |2       |


