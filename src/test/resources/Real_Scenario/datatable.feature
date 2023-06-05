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


