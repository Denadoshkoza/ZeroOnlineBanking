Feature: Pay Bills Page

  Scenario Outline: Make an successful payment
    Given the user has logged in the page
    When the user navigates to page "<Page>"
    Then "<Page>" page should have title "<Title>"
    Examples:
      | Page      | Title            |
      | Pay Bills | Zero - Pay Bills |
  @wip
    Scenario: Complete a successful Pay operation
      Given the user has logged in the page
      And the user navigates to page "Pay Bills"
      When the user completes a successful Pay operation
      Then The message "The payment was successfully submitted" should be displayed