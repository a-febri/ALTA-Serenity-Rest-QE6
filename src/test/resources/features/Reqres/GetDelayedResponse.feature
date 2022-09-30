Feature: Get delay
  @tugas
  Scenario: Get delayed with parameter value
    Given Get delayed response with valid parameter delay 3
    When Send request to get delayed response
    Then Should return 200 OK
    And Get delayed response json schema validator