Feature: Get list resource
  @tugas
  Scenario: Get list resource valid path
    Given Get list resource with valid path "unknown"
    When Send request to get list resource
    Then Should return 200 OK
    And Response body page should be page 1 and total pages are 2
    And Get list resource json schema validator

  @tugas
  Scenario Outline: Get list resource invalid path
    Given Get list resource with invalid path "<path>"
    When Send request to get list resource
    Then Should return 404 not found
    Examples:
      |path|
      |%#&*#*|
      |unkdheu|
      |6347   |

  @tugas
  Scenario: Get list resource valid parameter page
    Given Get list resource with parameter page 2
    When Send request to get list resource with param
    Then Should return 200 OK
    And Response body page should contain page 2
    And Get list resource json schema validator

