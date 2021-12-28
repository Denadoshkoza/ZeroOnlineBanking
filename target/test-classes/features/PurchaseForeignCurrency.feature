
Feature:    Purchase Foreign Currency
Background: 
  Given the user is logged in
  Then the user navigates to page "Pay Bills"
  Scenario:   Available currencies
    Given the user accesses the "Purchase Foreign Currency" cash tab
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar) 	  |

  Scenario:	Error message for not selecting	currency
    Given the user accesses the "Purchase Foreign Currency" cash tab
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed
  @wip
  Scenario:	Error message for not entering value
    Given the user accesses the "Purchase Foreign Currency" cash tab
    When user tries to calculate cost without entering a value
    Then error message should be displayed