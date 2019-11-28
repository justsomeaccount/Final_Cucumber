Feature: As User I want to login  under different roles

  Scenario: Login Test (Negative)

    Given Open	Vytrack	login	page
    When Enter	valid	username	and	invalid	password	information and click login
    Then Message	Invalid user name or password.should	be	displayed
    And Page	title	and	url	should


  Scenario: Login as a Store  Manager
    Given Open	Vytrack	login	page
    Then user logs in as a store manager
#  And user verifies that Dashboards page name is displayed
    And user verifies that "Dashboard" page name is displayed


  Scenario Outline: Login Test for all user types
    Given Open	Vytrack	login	page
    When user logs in as "<type>"
    Then user verifies that Dashboards page name is displayed

    Examples:
      | type         |
      | StoreManager |
      | SalesManager |
      | TruckDriver  |