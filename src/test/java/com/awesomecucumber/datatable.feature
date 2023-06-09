@dummyFeatures
Feature: Data Table

  @One
  Scenario: Single row with no header
    Given Single row with no header Credentials are

    |User1  |123  |

  @Two
  Scenario: Multiple rows with no header
    Given Multiple rows with no header Credentials are

      |User1  |123  |
      |User2  |456  |

  @Three
  Scenario: Single row with header
    Given Single row with header, Credentials are

      |username|password|
      |User1   |123     |

  @Four
  Scenario: Multiple rows with header
    Given Multiple rows with header, Credentials are

      |username|password|
      |User1   |123     |
      |User2   |456     |

  @Five
  Scenario: Single column with no header
    Given Single column with no header, Credentials are

      |User1   |
      |123     |

  @Six
  Scenario: Multiple columns with no header
    Given Multiple columns with no header Credentials are

      |User1  | User2 |
      |123    | 456   |

  @Seven
  Scenario: Single column with header
    Given Single column with header, Credentials are

      |username | user1|
      |password | 123  |

  @Eight
  Scenario: Multiple columns with header
    Given Multiple columns with header, Credentials are

      | username | john    | bill    |
      | password | john123 | bill123 |

