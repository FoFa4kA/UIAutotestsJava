Feature: Authorisation Page

  Scenario: Check input fields and login button activation

    Given Login button is disabled
    When User enters username password and username description
    Then Login button become active

  Scenario: Successful log in

    Given User enters valid username password and username description
    When User click login button
    Then Authorisation is successful

  Scenario: Logout

    Given User enters valid username password and username description
    When User click login button
    When Authorisation is successful
    When User click logout button
    Then Login page opens

  Scenario Outline: Attempts to log in with invalid data

    Given User enters invalid "<username>" "<password>" and username description
    When User click login button
    Then Incorrect credentials message appears
    Examples:
      | username     | password     |
      | invalid_data | invalid_data |
      | invalid_data | password     |
      | username     | invalid_data |