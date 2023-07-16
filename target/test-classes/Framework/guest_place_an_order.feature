Feature: Purchase Product

  As a customer of AskOmDch app, I should be able to add product(s) to the cart,
  So that I can purchase them.

  Scenario Outline: Place an order for a product

    Given I'm a customer
    And I'm on the Men Page
    When I add a "<product_name>" to the cart
    Then I see <quantity> "<product_name>" in the cart
    And I'm on the checkout page
    When I provide billing details

      |first_name|last_name|country   |street      |town |state |zip |phone      |email             |
      |Mustafizur|Rahman   |Bangladesh|Narayanganj |Dhaka|Dhaka |1250|01686026037|mustafiz@gmail.com|

    And I place an order
    Then The order should be placed successfully

    Examples:
      |product_name     |quantity|
      |Faint Blue Jeans |1       |

  #cusDef
  #storeDef
  #storeDef
  #cartDef
  #checkoutDef
  #checkoutDef
  #checkoutDef
  #checkoutDef