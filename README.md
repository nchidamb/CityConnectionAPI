# CityConnectionAPI

Rest API to determine if two given cities are connected. This is a Maven project built using Spring Boot and Java 8.<br/>
Here are the content of the project.

	src/main/java - Contains all the Java files of the Spring Boot App
	src/main/resource - Contains the property files and the input file (cities.txt and application.properties)
	src/test/java - Contains all the Unit test cases written using JUnit and Mockito, the Automation test 
	                (Spring Boot Test) which covers happy path scenarios and bad input data scenarios.
	src/test/resources - Contains all the resources needed for Unit test

And here are the threshold limits used to fail the build when it does not meet the requirement:

	Java Code Coverage
		Class Coverage - 100%
		Line Coverage - 95%
		Method Coverage - 95%
		Branch Coverage - 95%
	PIT Mutation Coverage - 95%

# Test Results

	city.txt content is:
	Boston, New York
	Philadelphia, Newark
	Newark, Boston
	Trenton, Albany
	
	Outputs are here:
	http://localhost:8080/connected?origin=Boston&destination=Newark	Yes
	http://localhost:8080/connected?origin=Boston&destination=Philadelphia	Yes
	http://localhost:8080/connected?origin=Philadelphia&destination=Albany	No
	http://localhost:8080/connected?origin=Boston&destination=Dallas	No
	http://localhost:8080/connected?origin=Boston				destination parameter is missing
	http://localhost:8080/connected?destination=Boston			origin parameter is missing

# Data Structure & Complexity
	
	Map<String, Set<String>> is the Collection used to hold all the cities as the key and their connections
	as the value. The Map is loaded from the input file when the App is booted.
	
	Breadth First Traversal is the Algorithm used in this API to determine if the cities are connected. 
	Queue<String> is used in memory to hold all the cities to be visited, and Set<String> is used to hold 
	all the cities already visited.
	The time complexity is O(V + E), when V is number of cities and E is number of connections. 

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
