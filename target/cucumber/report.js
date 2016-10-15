$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('br/com/unicamp/example/GoogleSearch.feature');
formatter.feature({
  "line": 1,
  "name": "Search on Google",
  "description": "As an user\nI want to search on Google\nSo that I can see results",
  "id": "search-on-google",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "results are shown",
  "description": "",
  "id": "search-on-google;results-are-shown",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "the page is open \"http://www.google.com\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I search for \"Cucumber\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "a browser title should contains \"Cucumber\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.google.com",
      "offset": 18
    }
  ],
  "location": "GoogleSearchScenario.the_page_is_open(String)"
});
formatter.result({
  "duration": 1492323400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Cucumber",
      "offset": 14
    }
  ],
  "location": "GoogleSearchScenario.I_search_for(String)"
});
formatter.result({
  "duration": 91864127,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Cucumber",
      "offset": 33
    }
  ],
  "location": "GoogleSearchScenario.a_browser_title_should_contains(String)"
});
formatter.result({
  "duration": 559731544,
  "status": "passed"
});
});