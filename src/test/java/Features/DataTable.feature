Feature: Insert & Delete record from the web table

  Scenario Outline: Validate a new record is create into the table
    Given User is on the DataTable Page
    When User inserts the record <FirstName>,<LastName>,<Username>,<Password>,<Customer>,<Role>,<EMail>,<Cell>
    Then The Record is successfully added to the table

    Examples:
    |FirstName|LastName|Username|Password|Customer|Role|EMail|Cell|
    |Ankur|Chaudhary|Ankur2622|Password123|Company AAA|Sales Team|test@test.com|9991119999|


  Scenario: Validate the record is deleted from the table
    Given User is on the DataTable Page
    When User 'novak' is present in Table
    And Delete button is clicked
    Then The Record is successfully deleted from the table
