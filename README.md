Spring Boot MongoDB Sample
==========================

Spring Boot with MongoDB integration

Requirements
------------
* [Java Platform (JDK) 8 or up](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.x](http://maven.apache.org/)
* [MongoDB](http://www.mongodb.org/)

Quick start
-----------
1. Import the project into Eclipse as Maven project
2. Read MongoDB setup described below
3. Find `Application.java` from side bar, right click on the file, select 'Run As' > 'Java Application' from menu.
5. Make a POST request to [http://localhost:8080/users](http://localhost:8080/users) with the payload: `{"firstname":"Bon","lastname":"Linus","items":[{"itemName":"iPhone","quantity":1},{"itemName":"Apple","quantity":3}]}`
6  Make a GET request to [http://localhost:8080/users](http://localhost:8080/users)
7. There are more endpoints. For details, check `UserController.java`

MongoDB Setup
--------------
1. Open Terminal or Command Prompt
2. Run MongoDB `$ mongod --dbpath /YOUR/MONGODB/STORE/DIRECTORY`
3. On Eclipse, check the configuration file, `Beans.java` to point to your MongoDB
