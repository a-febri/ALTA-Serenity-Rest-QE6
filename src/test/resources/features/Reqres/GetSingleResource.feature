Feature: Get single resource
  @tugas
  Scenario: Get single resource with valid id
    Given Get single resource with id 2
    When Send request to get single resource
    Then Should return 200 OK
    And Response body page should be id is 2 name "fuchsia rose" year 2001 color "#C74375" and pantone value "17-2031"
    And Get single resource json schema validator

  @tugas
  Scenario Outline: Get single resource invalid id above expected value
    Given Get single resource with id <id>
    When Send request to get single resource
    Then Should return 404 not found
    Examples:
      |id|
      |45|
      |980|

  @tugas
  Scenario Outline: Get single resource invalid id with value string
    Given Get single resource with id "<id>"
    When Send request to get single resource
    Then Should return 404 not found
    Examples:
      |id|
      |udwh|
      |@^@(_|
      |jhkw56ikl|
      |$@%jdj6bdh|