quotes-api-automation
----------------------------------------
Rest assured cucumber based Behaviour driven development style api automation project for automating the - https://favqs.com/api
This project has test for the LIST QUOTES and Fav Quotes end points automated.


Tools
----------------------------------------
1. Maven
2. Cucumber-JVM
3. JUnit
4. Java 8
5. testng
6. log4j
7. rest-assured
8. gson
9. Json
10. fasterxml-jackson

Requirements
---------------------------------------
In order to utilise this project you need to have the following installed locally:

1. Maven 3
2. java 1.8
3. You will need to create an account to generate an api key at https://favqs.com/api

Usage
-----------------------------------------
The project is broken into separate modules for API testing. Each of these modules can be utilised independently of the others using maven profiles.

To run all modules, navigate to quotes-api-autoamtion directory and run:

mvn clean install

To run api tests, navigate to test-automation-quickstart directory and run:

mvn clean install -Pui-acceptance-tests



   
   
