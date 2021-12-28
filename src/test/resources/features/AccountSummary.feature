

Feature: Account Summary

  Scenario Outline: <Page> page should have <Account Type>
    Given the user has logged in the page
    When "<Page>" page should have title "<Title>"
    Then the "<Page>" page should have Account type: "<Account Type>"
    Examples:
      | Page            | Title                  | Account Type        |
      | Account Summary | Zero - Account Summary | Cash Accounts       |
      | Account Summary | Zero - Account Summary | Investment Accounts |
      | Account Summary | Zero - Account Summary | Credit Accounts     |
      | Account Summary | Zero - Account Summary | Loan Accounts       |

  Scenario Outline: <Account Type> table must have columns <Columns>
    Given the user has logged in the page
    When  the user is in "<Account Type>" table
    Then the "<Account Type>" table must have columns "<Columns>"
    Examples:
      | Account Type    | Columns     |
      | Credit Accounts | Account     |
      | Credit Accounts | Credit Card |
      | Credit Accounts | Balance     |



