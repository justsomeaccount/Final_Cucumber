Feature: User should be able manage vehicles under fleet module


  Scenario: User should be able to create a new car
    Given Open	Vytrack	login	page
    When user logs in as a store manager
    Then user navigates to "Fleet" module "Vehicles"
    And user creates a car using info:
      | License Plate | 11xxx1235 |
      | Driver        | Mehmet    |
      | Color         | White     |
      | Vehicle Model | 520       |
      | Vehicle Make  | BMW       |

#    And user can verify that new car added to inventory by "License Plate" "1"
#    Then user can verify that new car added to DB
