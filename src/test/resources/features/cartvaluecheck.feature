Feature: Add to Cart for different

  Background:
    Given invoke the application

  @smoke
  Scenario Outline: add different quantity to the cart
    Given  I am on the store page
    When I add a "<Product_Name>"
    Then I see 1 "<Product_Name>" in the cart
    Examples:
      |Product_Name  |
      |Blue Shoes    |
      |Red Shoes    |
