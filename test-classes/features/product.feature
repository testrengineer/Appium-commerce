Feature: Product List

  Scenario Outline: Sort Product List by Name
    Given user in homepage
    When I sort the product list by name in <order> order
    Then the products should be displayed <order> by name

  Examples:
    |order|
    |ascending|
    |descending|

  Scenario Outline: Sort Product List by Price
    Given user in homepage
    When I sort the product list by price in <order> order
    Then the products should be displayed <order> by price

    Examples:
      |order|
      |ascending|
      |descending|



