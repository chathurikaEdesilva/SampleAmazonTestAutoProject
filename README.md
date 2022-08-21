# README
This project contains a sample that login to Amazon, Search for a TV, Add a TV to cart and Proceeding to Checkout

### Technologies used
- Testng
- Selenium
- Maven
- Java

### Project Features
1. Ability to run on both firefox and chrome
2. Configs and test data separation by properties files
3. Surefire report generation
4. Screenshots on test failures

### Tested on
 - Chrome browser version: 104.0.5112.102
 - JDK 17


### Pre-requisites to run the test
- Maven
- Git
- Java
- Firefox / Chrome browser
- Relevant driver according to browser

### Steps to run

1. Clone below git repository

> https://github.com/chathurikaEdesilva/SampleAmazonTestAutoProject.git

2. Go to the repository

> cd $project_home

3. Open a terminal and issue the command to clean the repository

> mvn clean

4. Run the repository

> mvn test

### Viewing the result file

You can view the results from the following methods

1. Go to following location and open testng-results.xml

> $project_home/target/surefire-reports

2. Open the index.html file in a browser from the above location

### Changing the run to Firefox browser

1. Open src/main/configs/Configuration.properties
2. Provide value for the browser key as firefox
3. Provide the driver path to the driverPath
4. Put the relevant driver to drivers folder
5. Execute the above 3 and 4 steps in Steps to run sections

