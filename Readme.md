# Steps to run the Tests: 

## To Run all the tests use command from the terminal: 
1. mvn clean install

## To run specific tests use:
1. mvn test -Dcucumber.filter.tags="@CreateRecord"
2. mvn test -Dcucumber.filter.tags="@DeleteRecord"

## To run for Specific browser use:
1. mvn test -Dbrowser=Firefox 
2. mvn test -Dbrowser=Chrome

## Reports
To check reports of the test run, goto Reports folder under the Project Directory. The Reports are in Spark Report
directory with filename as Report.html