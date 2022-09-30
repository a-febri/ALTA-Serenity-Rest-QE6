Feature: Delete user
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
  Scenario Outline: Delete user with invalid id above expected value
    Given Delete user with invalid id <id>
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
    Given Delete user invalid id with special character "<id>"
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
    Given Delete user invalid path special character "<path>"
    When Send request delete user invalid path
    Then Should return 404 not found
    Examples:
      |path|
      |!@#*()#)_|
      |%!&#*@(_)|