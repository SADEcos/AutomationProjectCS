Feature: Cadastro e edicao de perfil de desenvolvedores


  Scenario: Sign up flow as a unregistered developer
    Given user is not logged in
    And I open the Sade page
    When I click on sign up link
    Then The browser should display the sign up form


  Scenario: Sign up form filling as a unregistered developer with correct information
    Given user is not logged in
    And the sign up form is opened
    When I fill the sign up form with correct information
    When submit the sign up form
    Then The browser should display the skills page

  Scenario: Filling a unregistered developer skills page
    Given user is not logged in
    And the sign up form is opened
    And submit the skills form
    Then The browser should display the success page with message "Seu registro foi feito com sucesso"







