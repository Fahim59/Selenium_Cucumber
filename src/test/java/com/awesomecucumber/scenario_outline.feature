Feature: Dummy feature

    Scenario Outline: Dummy Scenario 3
      Given my account balance is $<opening balance>
      When I withdraw $<withdraw amount>
      Then the account balance should be $<closing balance>

      #data can be group wise for different purpose (QA,Stage)

      @QA
      Examples:
      |opening balance|withdraw amount|closing balance|
      |100            |50             |50             |
      |200            |100            |100            |

      @Stage
      Examples:
        |opening balance|withdraw amount|closing balance|
        |50             |35             |15             |
        |150            |100            |50             |