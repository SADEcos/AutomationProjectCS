Feature: Busca de desenvolvedor


  Scenario: Search a unregistered Developer by Name
    Given the search page of developers is opened
    When I fill the name box with a unregistered developer name
    Then a browser should display 0 developers

  Scenario: Search a Developer by Name with correct information
    Given the search page of developers is opened
    When I fill the name box with a developer name
    Then a browser should display all developers with the same name

  Scenario: Search developers by language skills
    Given the search page of developers is opened
    When I click the language checkbox "python"
    Then The browser should display the language column "python"


  Scenario: Search developers by language skills
    Given the search page of developers is opened
    When I click the language checkbox "php"
    Then The browser should display the language column "php"


  Scenario: Search developers by language skills
    Given the search page of developers is opened
    When I click the language checkbox "python"
    Then The browser should not display the language column "python"
