Feature: Busca de desenvolvedor

  Scenario: Search a Developer by Name with correct information
    Given user is logged in as an administrator
    And the search page of developers is opened
    When I fill the name box with a developer name
    And submit the search form
    Then a browser should display all developers with the same name


  Scenario: Search a unregistered Developer by Name
    Given user is logged in as an administrator
    And the search page of developers is opened
    When I fill the name box with a unregistered developer name
    And submit the search form
    Then a browser should display an error message "No developers found"


  Scenario: Search developers by language skills
    Given user is logged in as an administrator
    And the search page of developers is opened
    When I select some language check boxes
    And submit the search form
    Then The browser should display all developers with all languages selected
