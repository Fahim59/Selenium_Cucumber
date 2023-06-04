@dummyFeatures
Feature: Add to cart
  Scenario: Navigate to store, add a product to the cart, click view cart link to navigate to the cart and verify
    Given I'm on the Home page and I navigate to the Store page by pressing "Store" menu option
    When I click "Add to cart" button next to the product "Blue Shoes"
    Then The "Add to cart" button changes and a tick mark is shown on it
    Then "View cart" link is shown
    When I click on the "View cart" link
    Then I'm navigated to the Cart page
    When I fetch the product name and quantity
    Then The product name is "Blue Shoes"
    And The product quantity is 1