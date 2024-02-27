Feature: Favourite Quotes and List quotes Endpoint

  Scenario: GET random list of quotes
    Given Get a random list of quotes by user DEFAULT_USER
    Then Verify that the list has 25 quotes


  Scenario Outline:  Mark a quote as a user's favorite using PUT request
    Given Mark a quote with id <id> as favourite by user <user>
    Then Validate that the status code is SUCCESS
    And Check that the quote with <id> has been marked as favourite by user <user>
    Examples:
      | id |   user         |
      | 5  |   DEFAULT_USER |
      | 4  |   DEFAULT_USER |


  Scenario: Search for quotes with search filter
    Given Get quotes containing the filter for word funny by user DEFAULT_USER
    Then Validate that the status code is SUCCESS
    And Verify that the list of quotes has word funny

  Scenario: Get quotes by a Author type
    Given Get quotes containing the filter "Mark Twain" for type author user DEFAULT_USER



  Scenario Outline: Get quotes by query parameters

    Then Get Quotes with filter as <filter> type as <type> hiddenFlag as <hidden> by user <user>
    #And Verify the Quotes is filtered by <filter> type as <type> hiddenFlag as <hidden> by user <user>

    Examples:
       | filter      | type    | hidden |user         |
       | funny       | NULL    | NULL   |DEFAULT_USER |
       | funny       | tag     | NULL   |DEFAULT_USER |
       | Mark Twain  | author  | NULL   |DEFAULT_USER |
       | 30522       | user    | NULL   |DEFAULT_USER |
       | NULL        | tag     | 1      |DEFAULT_USER |



