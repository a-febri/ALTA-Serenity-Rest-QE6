Feature: Put update user
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