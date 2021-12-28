
Feature:User should be able to log in only with valid credentials

  Scenario Outline: Login with valid credentials
    Given the user is on the login page
    When the user enters valid "<Username>" "<Password>"
    Then the user should be able to login with valid credentials
    Examples:
      | Username | Password |
      | username | password |

  Scenario Outline: Login with invalid credentials
    Given the user is on the login page
    When the user enters invalid "<Username>" "<Password>"
    Then the user should be able to login with valid credentials
    Examples:
      | Username  | Password  |
      | username1 | password2 |


