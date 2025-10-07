@productValidation
Feature: Verify Product Details and Add to Cart for Multiple Users

  Scenario: Users login, validate product details from Excel, add to cart, and logout
    Given user is logged in to swaglab
    When user adds a Sauce Labs Backpack to the cart and validates product details
    Then the cart should add 1 item
