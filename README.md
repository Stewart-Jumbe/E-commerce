# Ecommerce App – DfE Final Project 
<br /> 
<br /> 


## Project Overview

This repository contains the final project for QA Academy bootcamp and Software Development program. <br>
The e-commerce application created has full crud functionality, handles HTTP requests and connects to a persistent relational database.
It encapsulates concepts from all core modules:
* Agile & Project Management (Git, Jira)

* Databases & Cloud Fundamentals (H2, MySQL)
* Programming Fundamentals (Java)
* API Development (Spring Boot)
* Automated Testing (JUnit,Mockito)


### Scope <br /> 
<br /> 
  
The project requirements were to:  

  
* Use Feature-Branch Model: main/dev/feature for version control.<br /> 

* Create a project management board with full expansion on user stories, acceptance criteria and tasks needed to complete the project.<br />  
* Produce a risk assessment which outlines the issues and risks faced during the project timeframe.<br /> 
* Create a relational database, locally or within the Cloud, which is used to persist data for the project. <br />   
* Produce a functional application ‘back-end’, written in Java with a suitable framework (Spring Boot), which meets the requirements set on your Scrum Kanban board.<br />  
* Build a .Jar  application, including any dependencies it might need, produced using an integrated build tool (Maven). <br />  
* Make a series of API calls designed with postman, used for CRUD functionality. (Create, Read, Update, Delete). <br />  
* Fully design test suites for the application you are creating, including both unit and integration tests. <br /> 
<br /> 
<br /> 

## Why am I doing this? <br /> 
<br /> 
The purpose of this project is to demonstrate the Java software development skills I have acquired during the QA Academy Software Development Bootcamp.  
Building an executable application also illustrates my understanding of SOLID principles and familiarity with the tools and framework commonly used in the software development industry<br /> 
<br /> 

## How I expected the challenge to go<br /> 
<br /> 

I was excited by the opportunity to individually create my own app, but was also aware that there were areas that I did not have much practical experience in, 
such as Jira, and managing git branches on a live project. I felt that I had sufficient time to create the minimum viable product (MVP), and had adequate knowledge and resources to create the application.<br />     
<br /> 

## What went well<br /> 
<br /> 
I found the process of developing the app challenging and enjoyable. Although the project was an individual task rather than a group task, it was great to still have an opportunity to collaborate and help my colleagues, on the parts of the projects that were similar. Overall, developing the E-commerce app, provided wonderful experiences and further develop my understanding of fundamental Java principles such as unit and integration testing. <br /> 
<br /> 

## What didn't go as planned<br /> 
<br /> 
I found that the errors generated in testing the app were not very specific, which meant that it took longer to resolve issues. 
I think that as I spend more time programming with Java, I will develop a better understanding of what the error messages are pointing to. 
Furthermore, I could not get the Update functionality (a method called updateCustomerInfo ) to pass the unit testing with Mockito, although the method worked in practice.  
<br /> 

## Possible Improvements<br /> 
<br /> 
I would like to add the following functionality in the future: 
* Add a front-end to provide a better user experience, as they can use a browser rather than Postman.<br /> 
* Add more logic and custom exceptions to ensure users provide the correct data, and to give more specific messages for incorrectly entered data.<br /> 
* An Inventory Class which would allow users to add items they would like to sell.<br /> 
<br /> 
<br /> 

## API Functionality<br />  
<br /> 

The e-commerce app has CRUD functionality which allows the user to do the following:
* Create a new customer account<br />
* Dislay all of the customer accounts<br />
* Display a specific customer account (using the customer ID)<br />
* Update a customer account (using the customer ID)<br />
* Remove a customer account<br (using the customer ID) />

As this project focused on developing the back-end, users of the app can use Postman which simulates the fuctionality of a front-end.

## Jira

Jira was used to manage this project, my Jira board can be accessed [here](https://sjumbe.atlassian.net/jira/software/projects/MUS/boards/1/roadmap?shared=&atlOrigin=eyJpIjoiNDU1ODZhN2YzMjgxNDFmMjhmNDc3NWY2NDk5YjJkZGUiLCJwIjoiaiJ9), a project risk asssessment can be found on the board. 

## Installation

The default port for connecting Postman for locolhost requests is `port:8081`, communication to MySQL database is on `port:3306`.

A database called customeraccountdb with a table called customer_account must first be created using the instructions below, before the e-commerce application is run.

The following SQL query can be run in MySQL to create a new database and table:

```
CREATE DATABASE customeraccountdb;

USE customeraccountdb;

CREATE TABLE `customer_account`(
    id INTEGER AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    dob VARCHAR(255),
    address VARCHAR(255),
    postcode VARCHAR(255),
    PRIMARY KEY (id)
);
```
 
## Illustration of CRUD functionality in Postman<br />  
<br /> 

A new customer account can be created by using the **/customeracount/create** extension.<br>
To succefully perform this request follow the instructions below.

###### Using Postman:

1. Open a new Postman tab
2. Select `POST` request from drop-down list
3. Enter URL: http://localhost:8080/customeraccount/create
4. Select `Body` -> `raw` (to the right of the `raw`, select `JSON` type is from the drop-down list)
5. Enter input body (example shown below). <br>
```
{       "name": "Anna Will",
        "email": "Hiram_Feest@example.net",
        "dob": "11-01-1991",
        "address": "91793 Miller Trafficway",
        "postcode": "BA1 3AA"
}
```
Random customer data can be generated for the name, email and address fields by entering the following:

```
{      "name": "{{$randomFullName",
        "email": "{{$randomEmail}}",
        "dob": "11-01-1991",
        "address": "{{$randomStreetAddress}}",
        "postcode": "BA1 3AA"
}
```

### Creating a new customer account

Postman url:  http://localhost:8080/customeraccount/create

![img.png](https://github.com/Stewart-Jumbe/Ecommerce/blob/main/Documentation/Creating%20CustomerAccount.png)

### Displaying all customer accounts

Postman url:  http://localhost:8080/customeraccount/getall
![img.png](https://github.com/Stewart-Jumbe/Ecommerce/blob/main/Documentation/Getting%20all%20customers.png)

The image below shows the same list of customers in the H2 database used during testing
![img.png](https://github.com/Stewart-Jumbe/Ecommerce/blob/main/Documentation/H2%20database%20of%20Created%20All%20accounts.png)

The image below shows the same list of customers in a MySQL database used by the end customer (production version)
![img.png](https://github.com/Stewart-Jumbe/Ecommerce/blob/main/Documentation/H2%20database%20of%20Created%20All%20accounts.png)

### Display a specific customer account (using the customer ID of 2)

Postman url: http://localhost:8080/customeraccount/get/2

![img.png](https://github.com/Stewart-Jumbe/Ecommerce/blob/main/Documentation/Get%20by%20Customer%20ID.png)

### Updating a specific customer account (using the customer ID of 1)

Postman url: http://localhost:8080/customeraccount/replace/1

Image below shows the account of Howard having its data replaced/updated 
![img.png](https://github.com/Stewart-Jumbe/Ecommerce/blob/main/Documentation/Replacing%20Howard%20West%20with%20Stewart%20Right.png)

Image showing a confirmation of the replacement of Howard's account with Stewart was shown the Eclipse console
![img.png](https://github.com/Stewart-Jumbe/Ecommerce/blob/main/Documentation/console%20confirmation%20of%20replacement%20of%20howard.png)

### Deleting a specific customer account (using the customer ID of 1)

Postman url:http://localhost:8080/customeraccount/delete/1

Image below shows the account Eclipse console output when the account of Stewart was deleted 
![img.png](https://github.com/Stewart-Jumbe/Ecommerce/blob/main/Documentation/Confirmation%20of%20deletion%20of%20customer%20with%20id%201.png)

## Test coverage<br />  
<br /> 

Unit and intergration testing were performed, the output of the test coverage is shown below. The tests covered above 80% of the applications code.
![img.png](https://github.com/Stewart-Jumbe/Ecommerce/blob/main/Documentation/Testing%20Coverage.png)




