Feature: Department testing

  @testapi001
  Scenario Outline: Creating new Department
    Given I have the data to create department with "<departmentName>","<departmentAddress>","<departmentCode>"
    And I use department header
    When I send a post request to department resource
    Then I get status code 200 from the database



    Examples:
      | departmentName | departmentAddress | departmentCode  |
      | Recruiter      | 1232 test drivre  | highlands ranch |
      | HR             | 1232 test drivre  | highlands ranch |
      | Engineering    | 1232 test drivre  | highlands ranch |
      | Sales          | 1232 test drivre  | highlands ranch |
      | Recruiter      | 1232 test drivre  | highlands ranch |


  Scenario Outline:  Get Department giving a valid ID
      Given a path param as "<id>"
      And header is defined as application Json
      When I send a get request to the department resource
      Then the status code should be 200
      And the response body should contains "<departmentName>","<departmentAddress>","<departmentCode>"
      Examples:


        | id  | departmentName | departmentAddress | departmentCode  |
        | 100 | Recruiter      | 1234 test drive   | highlands ranch |
        | 200 | HR             | 1234 test drive   | highlands ranch |


Scenario Outline: Modify existing department
  Given an existing department with id "<id>"
  And content type is set to application Json
  When I send a patch request to the department resource
  Then I should get a response status code of "<statusCode>"
  And the response body should contained updated id record
  Examples:
    | id  | statusCode |
    | 100 | 200        |
    | 200 | 404        |
    | 300 | 404        |


Scenario Outline: Modify all the existing record
  Given a request body with valid "<departmentName>","<departmentAddress>","<departmentCode>"
  And I set content type to application Json
  When I send a put request to the department resource
  Then I should get a status code of "<statusCode>"
  And The response body should contains updated resource
  Examples:
    | departmentName | departmentAddress | departmentCode | statusCode |


  @testapi002
  Scenario Outline: Get all items from the department api
    Given I set the content type to application json
    When I sent a get request to the department resource
    Then the status code should be  "<statusCode>"
    And the response body is logged
    Examples:
      | statusCode |
      | 200        |




