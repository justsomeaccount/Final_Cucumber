Feature:Post JSON and verify JSON


  Scenario: User should be able to post a new employee on Oracle HR database

    Given Content type and Accept type is JSON
    When I post a new employee with <1235.0> id
    Then Status code is <201>
    And Response JSON should contain employee info
    When I send a GET request with <1235.0> id
    Then Status code is <200>
    And employee JSON response Data should match the posted JSON data




  Scenario: User should be able to post a new department on Oracle HR database

    Given Content type and Accept type is JSON
    When I post a new department with id <126>
    Then Status code is <201>
    And Response JSON should contain department info
    When I send a get request with <126> department id
    Then Status code is <200>
    And Department JSON response Data should match the posted JSON data


  @DB
  Scenario: User should be able to post a new job on Oracle HR Database
    Given Content type and Accept type is JSON
    When I post a new job with id "SDET5"
    Then Status code is <201>
    And Response JSON should contain job info
    When I send a GET request with "SDET5" id
    Then Status code is <200>
    And Job JSON response Data should match the posted JSON data


