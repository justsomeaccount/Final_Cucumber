Feature: User should be able to post/get data from API and DB


  Scenario: User should be able to create new department


    Given Content type and Accept type is JSON
    When I post a new department with name "Mehmet's Place4"
    And Status code is <201>
    Then User gets connection to "ORACLE" database
    And User runs the SQL query "select department_name from departments"
    And Verify if "DEPARTMENT_NAME" has "Mehmet's Place4" value on DB
    Then Close DB connections


#
#{
#"job_id": "AC_ACCOUNT",
#"job_title": "Public Accountant",
#"min_salary": 4200,
#"max_salary": 9000

  @wip
  Scenario: User should be able to create a new job

    Given Content type and Accept type is JSON
    When I post a new job with following information
      | job_id     | SDET                                  |
      | job_title  | Software Development Engineer in Test |
      | min_salary | 67000                                 |
      | max_salary | 150000                                |

    And Status code is <201>
#    Then User gets connection to "ORACLE" database
#    And User runs the SQL query "Select * from jobs"
#    And Verify if "JOB_TITLE" has "SDET" value on DB
#    Then Close DB connections
