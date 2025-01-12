Readme

Used tools and libraries
Selenium 4.25
TestNG 7.10.2
Cucumber -7.15.0
Java 11

Prerequisites:
Chrome
Firefox

Steps to execute the Project:
Pull the code to local
Execute tests using mvn command : mvn test -DsuiteXmlFile=testng.xml



Explanation:

Main Package: The root package containing all other components.

automation_framework: Package containing utility classes.
DriverUtils: Handles driver initialization and management.
Utils: Contains common utility methods like file handling, logging, etc.
CommonUtils: General utility methods.
CucumberExtentReportListener: Custom listener for Cucumber and ExtentReports integration.
ExtentReportListener: Listener for generating ExtentReports.
FileUtils: File handling utilities.
LoggerUtil: Logging utilities.

test: Package containing test classes.
Core_Product_Tests: Package for core product tests.
Pages: Contains page object classes for core product tests.
StepDefinitions: Contains step definitions for core product tests.

Derived_Product2_Tests: Package for derived product tests.
Pages: Contains page object classes for derived product tests.
StepDefinitions: Contains step definitions for derived product tests.

TestRunner: Class responsible for running the tests.
resources: Package for storing configuration files, properties, etc.




