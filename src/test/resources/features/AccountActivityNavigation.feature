Feature: Account Activity page


  Scenario Outline: Account Activity page should have all expected components
    Given the user has logged in the page
    When the user navigates to page "<Page>"
    And "<Page>" page should have title "<Title>"
    Then in the Account drop down default option should be Savings
    And Account drop down should have the options "<Options>"
    Then Transactions table should have following column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
    Examples:
      | Page             | Title                   | Options     |
      | Account Activity | Zero - Account Activity | Savings     |
      | Account Activity | Zero - Account Activity | Checking    |
      | Account Activity | Zero - Account Activity | Loan        |
      | Account Activity | Zero - Account Activity | Credit Card |
      | Account Activity | Zero - Account Activity | Brokerage   |

