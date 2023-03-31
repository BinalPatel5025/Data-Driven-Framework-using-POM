# Data-Driven-Framework-using-POM
A data-driven framework is where test input and output values are read from data files (ODBC sources, CVS files, Excel files, DAO objects, ADO objects, and such) and are loaded into variables in captured or manually coded scripts. In this framework, variables are used for both input values and output verification values. Using POM - page object model approch to create a seprate java class for all web page. Use maven to download dependency and generate Extent report.

### Tools

* Eclipse 
* Java 
* Selenium WebDriver 
* Apacha POI
* TestNG
* POM
* Extent Report
* Maven

### Framework Structure:

The framework consists of the following components.

src/main/java
  * com.project.qa.base
      - TestBase.java
  * com.project.qa.config
      - config.properties
  * com.project.qa.pages
      - ContactsPage.java
      - DealsPage.java
      - HomePage.java
      - LoginPage.java
      - SignUpPage.java
      - TaskPage.java
  * com.project.qa.testdata
      - FreeCRMTestData.xlsx
  * com.project.qa.util
      - TestUtil.java
      - WebEventListener.java
  * com.qa.ExtentReportListener
      - ExtentReporterNG.java
      
 src/test/java   
 
  * com.project.qa.testcases
      - ContactsPageTest.java
      - HomePageTest.java
      - LoginPageTest.java
      
 src/main/resoources
 
      - log4j.properties
      - testng_sanity.xml
      - testng.xml

