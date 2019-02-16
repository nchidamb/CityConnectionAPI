# CityConnectionAPI

API to determine if two given cities are connected

# Prerequisites to run the app

Java 8
Maven 3.x

# How to run the app

Build the project:
	Command - mvn clean install
	This will compile, run the unit tests and Integration tests, measure java code coverage & mutation coverage and generate the reports.
Run as Spring Boot Application 
	Command - mvn spring-boot:run or 
	Right click the project on the IDE and run as Spring Boot Application

# Links

API endpoint to test the app in local - http://localhost:8080/connected
Java Code Coverage report - {project-workspace}/target/site/jacoco/index.html
PIT Mutation coverage report - {project-workpace}/target/pit-reports/{datetime}/index.html
Swagger Rest Documentation - http://localhost:8080/swagger-ui.html