Feature: Cart Feature

  Scenario: Validate cart is empty when no items are added
    Given user in homepage
    When the user opens the cart
    Then the cart should be empty

  Scenario: Validate item can be added to cart
    Given user in homepage
    When user add item to cart
    And the user opens the cart
    Then the item should be added to cart

  Scenario: Validate item removed from cart
    Given user in homepage
    When user add item to cart
    And the user opens the cart
    And user remove item from cart
    And the user opens the cart
    Then the item should be removed from cart

  Scenario: Validate change quantity in cart
    Given user in homepage
    When user add item to cart
    And the user opens the cart
    And user add quantity from cart
    Then the item quantity should be added
