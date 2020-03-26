# Spring boot bank
* [Short Description](#description)
* [Project Structure](#structure)
* [Setup Guide](#setup)

<hr>

# <a name="description"></a>Short description
In this project I attempted to implement basics functions of an online bank:
 - **Bank** stores data about: 
    * clients;
    * accounts;
    * transactions;
 - **Application** has 3 pages: 
     * **/Clients**;
     * **/Accounts**;
     * **/Transfer**;
    
In this application you have an ability to: 
 * show the list of Clients with filter by First Name/Last Name;
 * show all Client's accounts;
 * add new Account for particular Client;
 * add new Client;
 * show the list of Transactions with filter by Name;
 * add new Transaction;
 
 First, you need to add new Client and only after that you can add new Account for this Client and add some transaction.

<hr>

<a name="structure"><h2>Project structure</h2></a>

  * Java 1.8

  * Maven 4.0.0
  
  * Tomcat
  
  * MySQL

  * spring-boot-starter-web

  * spring-boot-starter-thymeleaf

  * spring-boot-devtools

  * mysql-connector-java

  * lombok

<a name="developer"><h2>Setup Guide</h2></a>

Open the project in your IDE.

Add it as maven project.

Configure Tomcat:

- add artifact;

- add sdk 13;

Create a schema "springbankdb" in any SQL database:

- Run in your SQL database the following code

DROP SCHEMA IF EXISTS springbankdb;

CREATE SCHEMA springbankdb;

USE springbankdb;

Run the project.

To run project from command line:

- start command line;
- maven package;
- mvn install;
- java -jar target/spring-bank-0.0.1-SNAPSHOT.jar;

#Author
[Misha_Podoliaka](https://github.com/MikePodoliaka)