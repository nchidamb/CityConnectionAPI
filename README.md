# CityConnectionAPI

API to determine if two given cities are connected

# Prerequisites to run the app

Java 8 <br/>
Maven 3.x

# How to run the app

Build the project: <br/>
	Command - mvn clean install<br/>
	This will compile, run the unit tests and Integration tests, measure java code coverage & mutation coverage and generate the reports.<br/><br/>
Run as Spring Boot Application <br/>
	Command - mvn spring-boot:run or <br/>
	Right click the project on the IDE and run as Spring Boot Application<br/>

# Links

API endpoint to test the app in local - http://localhost:8080/connected<br/>
Java Code Coverage report - {project-workspace}/target/site/jacoco/index.html<br/>
PIT Mutation coverage report - {project-workpace}/target/pit-reports/{datetime}/index.html<br/>
Swagger Rest Documentation - http://localhost:8080/swagger-ui.html<br/>
