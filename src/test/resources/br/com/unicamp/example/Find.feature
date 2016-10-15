Feature: Find developers
  As an admin user
  I want to find a dev
  So that I can see it on Find Developers page

  Scenario: List all developers
    Given administrator is logged in
    When I open the Find Developers page
    Then I see the full list of developers
  
  Scenario: Filter developers by language
    Given administrator is logged in
      And Find Developers page is opened
    When I open filter the language by "Java"
    Then I see the full list of Java developers
    
  Scenario: Filter developers by multi-language
	Given administrator is logged in
      And Find Developers page is opened
    When I open filter the language by "Java" and "Python"
    Then I see the full list of Java && Python developers
    	
  Scenario: Filter developers by name
	Given administrator is logged in
      And Find Developers page is opened
    When I input on filter name "Safira"
    Then I see the full list of developers whose name contains "Safira"
        	

    
  