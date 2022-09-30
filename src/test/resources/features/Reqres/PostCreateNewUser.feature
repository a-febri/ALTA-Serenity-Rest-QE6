Feature: Post create new user
  @latihan
  Scenario: Post create new user with valid json
    Given Post create new user
    When Send request post create new user
    Then Should return 201 created
    And Response body should contain name "Ari Febri" and job "QA Engineer"
    And Post create new user json schema validator

  @tugas
  Scenario: Post create new user without name
    Given Post create new user input job empty name
    When Send request post create new user
    Then Should return 400 bad request

  @tugas
  Scenario: Post create new user without job
    Given Post create new user input name empty job
    When Send request post create new user
    Then Should return 400 bad request

  @tugas
  Scenario: Post create new user without name and job
    Given Post create new user empty name and job
    When Send request post create new user
    Then Should return 400 bad request
