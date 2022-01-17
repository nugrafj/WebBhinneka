Feature: Add product to cart (B)
  

  Scenario Outline: Add product from category
    Given I login to Bhinneka Web
    When I search for products from category
    And I use filters for product
    And add product to cart
    Then I verify the current page is checkout page
    And I verify the product