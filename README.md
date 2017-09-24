Airport MVC App(Read ME)
=====================================================================

Tools Used:
1. Java (1.8.0_91)
2. Spiring Tool Suite (v 4.6.2)
3. Maven
6. Junit


Solution Outline:.
1)  This is simple Java Spring Boot app which reads three separate CSV files for the data and processes infomation to the end user.	
2)	The user can search for a country based on the country name or country code (as specified in the country.csv)
3)	The user can also specify portion of the country name to get the correct resuls
4)	The application has a reports page which generates these reports : 
	a. 10 countries with highest number of airports (with count) 
	b. Type of runways (as indicated in "surface" column) in the top 10 countries.
	c. Countried with lowest number of airports.
5)	For JAR dependencies I have used Maven.

Build and Run Instruction:

Eclipse:
1) Download the contents from GitHub , unzip the content 
2) Add as an existing Maven project 
3) Right click on "AirportMvcAppApplication.java" file Run As -> Spring Boot App
4) Access the app at "localhost:8080/"

Command Prompt :
1) Download the contents from GitHub , unzip the content 
2) Execute following maven command to create an executable WAR `mvn clean install`. This will create an executable WAR (airport-app.war)
3) Run the project using command "java -jar airport-app.war"
4) Access the app at "localhost:8080/"

