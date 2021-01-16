Feature: Match the prices from search results and Cart
  Scenario: Product's price should be consistent

    Given User on the home page and login as an authorized user
    And User search "qa testing for beginners"
    And User selects the first search results
    Then Price under search result and Product's detail page should match
    When User clicks on Add to cart button
    Then under search result price and cart price should match
    When user clicks on proceed to check out
    Then Check out price and search page price should match