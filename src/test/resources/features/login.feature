Feature: Authorisation Page

  Scenario: Input fields and Login button

    Given Login button is disabled
    When User enters username password and username description
    Then Login button become active

  Scenario: Successful authorisation

    Given User enters valid username password and username description
    When User click login button
    Then Authorisation is successful

  Scenario: Authorisation with invalid data

    Given User enters invalid username password and username description
    When User click login button
    Then Incorrect credentials message appears

  Scenario Outline:

    Given User enters invalid "<username>" "<password>" and username description
    When User click login button
    Then Incorrect credentials message appears
    Examples:
      | username     | password     |
      | invalid_data | invalid_data |
      | invalid_data | password     |
      | username     | invalid_data |