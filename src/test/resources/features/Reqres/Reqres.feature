Feature: Features to Reqres
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

  @latihan
  Scenario: Post create new user with valid json
    Given Post create new user
    When Send request post create new user
    Then Should return 201 created
    And Response body should contain name "Ari Febri" and job "QA Engineer"
    And Post create new user json schema validator

  @latihan
  Scenario Outline: Put update user with valid json
    Given put update user with id <id>
    When Send request put update user
    Then Should return 200 OK
    And Response body should contain name "Ari Edit" and job "QA Edit"
    And Put update user json schema validator
    Examples:
    |id|
    |1 |
    |2 |
  @latihan
  Scenario Outline: Delete user with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return 204 no content
    Examples:
    |id|
    |1 |
    |2 |


  @tugas
  Scenario Outline: Get list user with invalid parameter page with char & special char
    Given Get list user with invalid parameter page "<page>"
    When Send request to get list user
    Then Should return 404 not found
    Examples:
      |page|
      |#^%@&* |
      |wqwe   |

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

  @tugas
  Scenario: Get delayed with parameter value
    Given Get delayed response with valid parameter delay 3
    When Send request to get delayed response
    Then Should return 200 OK
    And Get delayed response json schema validator

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

  @tugas
  Scenario Outline: Put update user without input job
    Given Put update user with id <id> only input name
    When Send request put update user
    Then Should return 400 bad request
    Examples:
      |id|
      |1 |
      |2 |

  @tugas
  Scenario Outline: Put update user without input name
    Given Put update user with id <id> only input job
    When Send request put update user
    Then Should return 400 bad request
    Examples:
      |id|
      |1 |
      |2 |

  @tugas
  Scenario Outline: Put update user without input any body json
    Given Put update user with id <id> empty name empty job
    When Send request put update user
    Then Should return 400 bad request
    Examples:
      |id|
      |1 |
      |2 |

  @tugas
  Scenario Outline: Put update user without invalid path with character and valid json
    Given Put update user with invalid path "<path>" valid json
    When Send request put update user invalid path
    Then Should return 404 not found
    Examples:
      |path|
      |usersssdh |
      |sjusjserjhs |

  @tugas
  Scenario Outline: Put update user without invalid path with special character and valid json
    Given Put update user with invalid path "<path>" with special char valid json
    When Send request put update user invalid path
    Then Should return 404 not found
    Examples:
      |path|
      |%&*#&&*@ |
      |^#*&*(@ |
#Delete
  @tugas
  Scenario Outline: Delete user with valid invalid id above expected value
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return 404 not found
    Examples:
      |id|
      |163 |
      |762 |

  @tugas
  Scenario Outline: Delete user invalid id with character
    Given Delete user invalid id with character "<id>"
    When Send request delete user
    Then Should return 404 not found
    Examples:
      |id|
      |urieokk |
      |uierieo |

  @tugas
  Scenario Outline: Delete user invalid id with special character
    Given Delete user invalid id with character "<id>"
    When Send request delete user
    Then Should return 404 not found
    Examples:
      |id|
      |*^(#*#%|
      |)$^#($%|

  @tugas
  Scenario Outline: Delete user invalid path with character
    Given Delete user invalid path with character "<path>"
    When Send request delete user invalid path
    Then Should return 404 not found
    Examples:
      |path|
      |useerrsss/2|
      |usjrekjers|

  @tugas
  Scenario Outline: Delete user invalid path with special character
    Given Delete user invalid path with character "<path>"
    When Send request delete user invalid path
    Then Should return 404 not found
    Examples:
      |path|
      |!@#*()#)_|
      |%!&#*@(_)|