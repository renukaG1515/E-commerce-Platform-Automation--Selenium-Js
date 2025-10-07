@Cart
Feature: Shopping Cart

  Scenario: Add item to cart
    Given user is logged in
    When user adds a Sauce Labs Backpack to the cart
    Then the cart should show 1 item
