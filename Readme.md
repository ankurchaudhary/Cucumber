# To Checkout the Master Branch

## Use the following command to clone the Master branch: 
### git clone https://github.com/ankurchaudhary/Cucumber.git, 
### Use git ckeckout teladoc-takehome-test to checkout the PR

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
To check reports of the test run, goto Reports folder under the Project Directory.You will find a file Report.html 
which will show the output of test run