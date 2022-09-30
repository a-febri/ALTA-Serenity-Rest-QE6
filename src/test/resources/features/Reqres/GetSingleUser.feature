Feature: Get single user

  @tugas
  Scenario: Get single user with valid id
    Given Get single user with id 2
    When Send request to get single user
    Then Should return 200 OK
    And Response body page should contain id 2 first name "Janet" and last name "Weaver"
    And Get single user json schema validator

  @tugas
  Scenario Outline: Get single user invalid id with special character
    Given Get single user invalid id "<id>"
    When Send request to get single user
    Then Should return 404 not found
    Examples:
      |id|
      |#%^%&$|
      |%&*#&(# |

  @tugas
  Scenario Outline: Get single user invalid id with character
    Given Get single user invalid id "<id>"
    When Send request to get single user
    Then Should return 404 not found
    Examples:
      |id|
      |iejdi|
      |tfws  |

  @tugas
  Scenario Outline: Get single user invalid id with character and special character
    Given Get single user invalid id "<id>"
    When Send request to get single user
    Then Should return 404 not found
    Examples:
      |id|
      |ie&$#(*jdi|
      |tf#U*(ws  |

  @tugas
  Scenario Outline: Get single user invalid id above expected value
    Given Get single user invalid id above expected value <id>
    When Send request to get single user
    Then Should return 404 not found
    Examples:
      |id|
      |23|
      |35453|