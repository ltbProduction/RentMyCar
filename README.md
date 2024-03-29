
# RentMyCar
* Web Development DHBW Ravensburg WWI118
* Group: RentMyCar
* Contributors: Linus Brugger, Lukas Blunck, Robin Birkhofer

## Documentation
With the help of this web-application, the users can publish their cars which they want to rent to other people. The users can put several specifications about their cars in a form on the website. The data is saved on a database. The users are also able to display an overview about the cars of other people with the specifications of the cars and a picture. The website helps to rent cars which are shown on the overview for a specific price and makes it easy to contact the owner of the car.  

### Technologies
The web-application uses the following technology stack:
* HTML
* CSS
* JavaServer Pages Standard Tag Library (JSTL)
* JavaServer Pages (JSP)
* Javascript
* Frameworks (client-side): Bootstrap
* Java Servlet
* Tomcat webserver
* MySQL Database

### Preconditions and Installation
The following preconditions are required to run this application:
1. Tomcat running
2. MySQL server running on localhost port 3306 with username root, password RentMyCar2019


Installation steps:
1. Checkout this repository
2. Copy the whole content to tomcats webapps folder
3. Run the code from createcarelements.sql in the SQL Workbench to create a matching database and table
4. Add servlet-api.jar and mysql-connectorr-java-8.0.18.jar to Build Path of your dynamic web project
5. Drop the jstl-1.2.jar in Web Content/WEB-INF/lib
6. Start tomcat
