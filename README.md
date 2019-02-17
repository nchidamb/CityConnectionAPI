# CityConnectionAPI

Rest API to determine if two given cities are connected. This is a Maven project built using Spring Boot and Java 8.	

# Prerequisites to run the app
	Java 8
	Maven 3.x

# How to run the app

## Build the project: <br/>
	Command Prompt - mvn clean install
This will compile, run the unit tests and Integration tests, measure java code coverage & mutation coverage and generate the reports

## Run as Spring Boot Application <br/>
	Command Prompt - mvn spring-boot:run 
	(Or)
	IDE(STS) - Right click the project on the IDE and run as Spring Boot Application

# How to test the app

After running the app in local, there are two ways to test the app.
	
	Use the API endpoint directly on a browser - http://localhost:8080/connected?origin=city1&destination=city2
	(Or)
	From Swagger Documentation Link - http://localhost:8080/swagger-ui.html

# Link to reports

After the project is built using maven, the below reports could be found in your local.

	Java Code Coverage report - {project-workspace}/target/site/jacoco/index.html
	PIT Mutation coverage report - {project-workpace}/target/pit-reports/{datetime}/index.html
