Feature: Get list users
  @latihan
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with parameter page <page>
    When Send request to get list user
    Then Should return 200 OK
    And Response body page should be <page>
    And Get list user json schema validation
    Examples:
      |page|
      |1   |
      |2   |

  @tugas
  Scenario Outline: Get list user with invalid parameter page with char & special char
    Given Get list user with invalid parameter page "<page>"
    When Send request to get list user
    Then Should return 404 not found
    Examples:
      |page|
      |#^%@&* |
      |wqwe   |
