Feature: Post login
  @tugas
  Scenario: Post login with valid value
    Given Post login with all valid value
    When Send request post login
    Then Should return 200 OK
    And Response body should contain token "QpwL5tke4Pnpja7X4"
    And Post login valid value json schema validator

  @tugas
  Scenario: Post login without input password
    Given Post login input email empty password
    When Send request post login
    Then Should return 400 bad request
    And Response body should contain error message "Missing password"
    And Post login error message json schema validator

  @tugas
  Scenario: Post login without input email
    Given Post login input password empty email
    When Send request post login
    Then Should return 400 bad request
    And Response body should contain error message "Missing email or username"
    And Post login error message json schema validator

  @tugas
  Scenario: Post login without any value
    Given Post login empty email empty passoword
    When Send request post login
    Then Should return 400 bad request
    And Response body should contain error message "Missing email or username"
    And Post login error message json schema validator

  @tugas
  Scenario: Post login with unregistered email
    Given Post login input unregistered email and password
    When Send request post login
    Then Should return 400 bad request
    And Response body should contain error message "user not found"
    And Post login error message json schema validator
