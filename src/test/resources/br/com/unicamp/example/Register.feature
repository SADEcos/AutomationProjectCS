Feature: Cadastro e edicao de perfil de desenvolvedores


  Scenario: Sign up flow as a unregistered developer
    Given user is not logged in
    And the login page is opened
    When I click on sign up link
    Then The browser should display the sign up form


  Scenario: Sign up form filling as a unregistered developer with correct information
    Given user is not logged in
    And the sign up form is opened
    When I fill the sign up form with correct information
    And submit the sign up form
    Then The browser should display the main page of developers


  Scenario: Sign up form filling as a unregistered developer with existent CPF
    Given user is not logged in
    And the sign up form is opened
    When I fill the sign up form with correct information
    And I fill the sign up form with existent CPF
    And submit the sign up form
    Then The browser should display an error message


  Scenario: Sign up form filling as a unregistered developer with incorrect information
    Given user is not logged in
    And the sign up form is opened
    When I fill the sign up form with incorrect information
    And submit the sign up form
    Then The browser should display an error message


  Scenario: Edit information flow as an logged in developer
    Given developer is logged in
    And the main page of developers is opened
    When I click the edit button
    Then The browser should display the sign up form
    And The sign up form should contain developer data


  Scenario: Editing information with correct information as an logged in developer
    Given developer is logged in
    And the edit page of developers is opened
    When I fill the sign up form with correct information
    And submit the sign up form
    Then The browser should display the main page of developers


  Scenario: Editing information with incorrect information as an logged in developer
    Given developer is logged in
    And the edit page of developers is opened
    When I fill the sign up form with incorrect information
    And submit the sign up form
    Then The browser should display an error message








