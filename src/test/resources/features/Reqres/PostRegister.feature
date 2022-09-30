Feature: Post register

  @tugas
  Scenario: Post register with valid body request
    Given Post register with all valid body request
    When Send request post register
    Then Should return 200 OK
    And Response body should contains id 4 and token "QpwL5tke4Pnpja7X4"
    And Post register with valid value json schema validator

  @tugas
  Scenario: Post register without password
    Given Post register input email empty password
    When Send request post register
    Then Should return 400 bad request
    And Response body should contain error message "Missing password"
    And Post register error message json validator

  @tugas
  Scenario: Post register without email
    Given Post register input password empty email
    When Send request post register
    Then Should return 400 bad request
    And Response body should contain error message "Missing email or username"
    And Post register error message json validator

  @tugas
  Scenario: Post register without any value
    Given Post register empty email empty password
    When Send request post register
    Then Should return 400 bad request
    And Response body should contain error message "Missing email or username"
    And Post register error message json validator
