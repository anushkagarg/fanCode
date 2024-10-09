# API Automation Framework
This project automates using Rest Assured and TestNG. The scenario involves checking that all users from the city FanCode have completed more than half of their todo tasks.
## Setup
Clone the repository:
- git clone repoName
- cd repoName
### Install the dependencies:
mvn clean install

### Running the Tests
To execute the tests, follow the following steps:
* Right click on project > Run Project as TestNg Project

### Dependencies
Ensure the following dependencies are there in pom.xml:

         
    <!-- https://mvnrepository.com/artifact/org.testng/testng -->
		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>7.7.1</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
		<dependency>
			<groupId>io.rest-assured</groupId>
			<artifactId>rest-assured</artifactId>
			<version>5.3.0</version>
		</dependency>
		<dependency>
            <groupId>com.aventstack</groupId>
            <artifactId>extentreports</artifactId>
            <version>5.0.9</version>
        </dependency>
        <dependency>
    		<groupId>com.googlecode.json-simple</groupId>
    		<artifactId>json-simple</artifactId>
    		<version>1.1</version>
		</dependency>
  </dependencies>
