Feature: Truck Driver have access to Vehicle Odometer


  Scenario Outline: Truck Driver should be able to create Vehicle Odometer
    Given Open	Vytrack	login	page
    When user logs in as "<type>"
#    Then user verifies that Dashboards page name is displayed
    And user navigates to "<tab>" module "<subTab>"
    And Clicks on Create Vehicle Odometer
    Then Fills the form, "<Odometer Value>", "<Driver>"
    And Save and Close
    Then User can verify that new vehicle odometer added to Database






    Examples:
      | type        | tab   | subTab           | Odometer Value | Driver    |
      | TruckDriver | Fleet | Vehicle Odometer | 114            | Mehmet114 |
      | TruckDriver | Fleet | Vehicle Odometer | 115            | Mehmet115 |
      | TruckDriver | Fleet | Vehicle Odometer | 116            | Mehmet116 |
