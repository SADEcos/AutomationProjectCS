Feature: Login into Sade
  As a anonymous user
  I want to open the Sade page
  So that I can see my index or login page

  Scenario: Login flow on Sade as a not logged user
    Given user is not logged in
    When I open the Sade page
    Then a browser should display the login page containing "Bem vindo ao SADE."

  Scenario: Login flow on Sade as a logged developer
    Given user is logged in as an developer
    When I open the Sade page
    Then a browser should display the main page of developers

  Scenario: Login flow on Sade as a logged admin
	Given user is logged in as an administrator
	When I open the Sade page
	Then a browser should display the main page of administrators
	
  Scenario: Unlogged admin flow
    Given user is not logged in
	When I fill administrator credentials and submit
	Then a browser should display the main page of administrators

  Scenario: Login flow on Sade as a logged developer
    Given user is not logged in
    When I fill developer credentials and submit
    Then a browser should display the main page of developers

  Scenario: Invalid credentials flow
    Given user is not logged in
	When I fill invalid credentials and submit
	Then a browser should display an error message "Login Inválido"

	