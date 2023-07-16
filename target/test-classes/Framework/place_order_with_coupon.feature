Feature: Apply a coupon code

  As a customer of AskOmDch app, I should be able to add product(s) to the cart,
  with a coupon code, So that I can purchase them.

  Scenario Outline: Place an order for a product with a coupon code

    Given I'm a customer
    And I'm on the Men Page
    When I add a "<product_name>" to the cart
    Then I see <quantity> "<product_name>" in the cart
    Then I apply "<coupon_code>"
    Then Coupon should be applied

    Examples:
      |product_name |quantity|coupon_code|
      |Green Tshirt |1       |off20      |