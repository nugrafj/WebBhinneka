Feature: Add product to cart (A)

  
  Scenario Outline: Add product from search feature
    Given I login to Bhinneka Web
    When I search for products from search feature
    And I increase the number of products
    And add product to cart
    Then I verify the current page is checkout page
    And I verify the product quantity 