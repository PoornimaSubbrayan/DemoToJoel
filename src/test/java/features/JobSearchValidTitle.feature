@jobsearchvalidtitle
  Feature: Job Search with valid job title
    As a job seeker
    I want to search for jobs on a NHS portal with valid job title
    So that i can find result found message

  Scenario Outline: User search for a job by passing with valid job title
    Given I am a job seeker on NHS Jobs website using "<browserName>" for valid title search
    When I enter correct job title and location in search
    Then I should get a list of jobs which matches my search criteria entered
    Examples:
    |browserName|
    |chrome|
    |edge|