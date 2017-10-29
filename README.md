# INGAtmManagerSpringBoot
A SpringBoot based MVC application

INGAtmManager:
Project Type:  Java Web Application

Objective:
•	A Java web application based on the standard servlet spec
•	The web application should provide a REST API to create a list of ING ATMs in a given Dutch city and return a well formed JSON response
•	The web application will invoke an external service to gather a super set of the
data: https://www.ing.nl/api/locator/atms/
•	Secure the API with Spring security
•	All code and classes delivered have Junit tests (Once after maven Build, the code coverage report will be available in target/site/jacoco/index.html). Right click on index.html, select open in browser

Technology Stack:
IDE                :      STS 3.8.2
Frame Work   :    Spring Boot v1.4.1, Spring Security, Spring Framework 4.3.3
Front End      :      Jsp, Jquery, Bootstarp, Google Chrome browser
Build              :      Maven
Unit Test        :     Mockito
REST API      :     Spring Rest
Server            :     Tomcat Server V8
Base URL      :     http://localhost:8080/ingatmmanager/
Code Coverage : Jacoco
Testing REST API : Postman or soapUI 

Credentials For Login:
username   :  user
password    :  temp

Deploying and Usage:
•	Once project is imported in STS IDE 3.8.2+, run maven build clean install, and clean the project. To deploy right click and run as spring boot and type the Base URL in browser.
•	The Application is secured by Spring Security, After deploying the application, we can access the application via the base URL. As the application is secured it will route you to the login page automatically.
•	Enter username and password given above

 

Secure the API with Spring security

•	On submit the application will route you to the home page
 

•	On home page we have a nav header with two tabs and a Button in Blue.
•	On click of Button in Blue, the user sees a table with Super set of Data in Table.
The Data is fetched by accomplishing below Task


The web application will invoke an external service to gather a super set of the
data: https://www.ing.nl/api/locator/atms/
 
•	User uses the Nav Tabs to go back to home Screen
•	Create ING ATM Tab in Nav 

On click of this tab the user will be routed to a page that allows creating of ING ATMs in a given Dutch city 

 

The user enter the city for which he/she wants to add ATMs and on click of Add ATM Details button the user will get a form to fill in the details. No validation is on the fields for now

 

The user enters the details of ATM and saves them, On save the user can be able to see the data he entered that is returned from the service

 

The user can Add more ATMs if he wishes or can go to homepage or create ATMs in another city by clicking create ING Atm tab.

 

On click save the user will be able to see the ATMs he created for a given Dutch city.
 

The user can keep adding or go to home page or click on Create ING Atm tab to create ATM for another Dutch city.



REST API : 

GET    :  api/getAllAtmDetails
URL   :  http://localhost:8080/ingatmmanager/api/getAllAtmDetails

Output: List of All ING Atms 

[
      {
      "address":       {
         "street": "Kerkstraat",
         "housenumber": "26",
         "postalcode": "3891 ET",
         "city": "Zeewolde",
         "geoLocation":          {
            "lat": 52.330156,
            "lng": 5.541664
         }
      },
      "distance": 0,
      "type": "ING"
   },
      {
      "address":       {
         "street": "Brugstraat",
         "housenumber": "14",
         "postalcode": "9711 HX",
         "city": "Groningen",
         "geoLocation":          {
            "lat": 53.21644,
            "lng": 6.560568
         }
      },
      "distance": 0,
      "type": "ING"
   },
……….
]


The web application will provide a REST API to create a list of ING ATMs in a given Dutch city and return a well formed JSON response

POST     :  api/createAtmDetailForCity
URL       : http://localhost:8080/ingatmmanager/api/createAtmDetailForCity

Input:
{
   "city": "Bloomington",
   "address":    [
            {
         "street": "S Washington st",
         "housenumber": "569",
         "postalcode": "61701",
         "city": "Bloomington",
         "geoLocation":{
            "lat": "25.366",
            "lng": "58.369"
         }
      },
            {
         "street": "N brook st",
         "housenumber": "562",
         "postalcode": "61701",
         "city": "Bloomington",
         "geoLocation":          {
             "lat": "52.658",
            "lng": "58.369"
         }
      }
   ]
}

Output:

You will get the same response back to display on the UI to view of the details you entered.

{
   "city": "Bloomington",
   "address":    [
            {
         "street": "S Washington st",
         "housenumber": "569",
         "postalcode": "61701",
         "city": "Bloomington",
         "geoLocation":{
            "lat": "25.366",
            "lng": "58.369"
         }
      },
            {
         "street": "N brook st",
         "housenumber": "562",
         "postalcode": "61701",
         "city": "Bloomington",
         "geoLocation":          {
             "lat": "52.658",
            "lng": "58.369"
         }
      }
   ]
}
