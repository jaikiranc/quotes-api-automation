quotes-api-automation
----------------------------------------
Rest assured cucumber based Behaviour driven development style, API automation project for automating the - https://favqs.com/api

This project has tests for the LIST QUOTES and Fav Quotes end points automated.


Tools
----------------------------------------
1. Maven
2. Cucumber-JVM
3. JUnit
4. Java 8
5. TestNG
6. Log4j
7. Rest-assured
8. Gson
9. Json
10. Fasterxml-jackson

Requirements
---------------------------------------
In order to utilise this project you need to have the following installed locally:

1. Maven 3
2. Java 1.8
3. You will need to create an account to generate an api key at https://favqs.com/api

Usage
-----------------------------------------
The project is broken into separate modules for API testing.

To run all modules, navigate to quotes-api-automation directory and run:

1.Navigate to **/src/test/java/com/hmh/cucumber/** directory and right click on **CucumberRunner** java file or Alternatively run below commands from the terminal
2. mvn clean
3. mvn install
4. mvn test
5. Go to reports/cucumber-html-report and open the index.html file in a browser to view the test results in readable format


To be done in future:
-----------------------------------------
1. Add extenstsreport plugin for reporting
2. Parameterize tests to run based on tags
3. Framework imporovements for Design patterns usage



   
   
