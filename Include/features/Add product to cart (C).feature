Feature: Add product to cart (C)
 

  Scenario Outline: Add product from flash sale
    Given I login to Bhinneka Web
    When I search for products flash sale
    And add two products to cart
    Then I verify the current page is checkout page
    And I verify the name of each product 
    And I verify the number of items purchased