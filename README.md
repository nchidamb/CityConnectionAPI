# CityConnectionAPI

Rest API to determine if two given cities are connected. This is a Maven project built using Spring Boot and Java 8. </br>	

# Prerequisites to run the app

Java 8 <br/>
Maven 3.x

# How to run the app

## Build the project: <br/>
	Command - mvn clean install<br/>
	This will compile, run the unit tests and Integration tests, measure java code coverage & mutation coverage and generate the reports<br/><br/>
	
## Run as Spring Boot Application <br/>
	Command - mvn spring-boot:run or <br/>
	Right click the project on the IDE and run as Spring Boot Application<br/>

# How to test the app

After running the 

Use the API endpoint directly on a browser - http://localhost:8080/connected?origin=city1&destination=city2<br/>
Swagger Rest Documentation - http://localhost:8080/swagger-ui.html<br/>

# Link to reports

Java Code Coverage report - {project-workspace}/target/site/jacoco/index.html<br/>
PIT Mutation coverage report - {project-workpace}/target/pit-reports/{datetime}/index.html<br/>
