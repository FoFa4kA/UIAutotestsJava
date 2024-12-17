Feature: Authorisation Page

  Scenario : Input fields and Login button

    Given user opens login page "https://www.way2automation.com/angularjs-protractor/registeration/#/login"
    When user enters username as "angular", password as "password" and username description as "description"
    Then login button become active