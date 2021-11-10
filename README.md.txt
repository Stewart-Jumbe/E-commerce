1.Created repo on desktop for ecommerce backend and linked it to my github
2.Created dev and features branch. Dev will be used for the creation of classes, features will be used for the creation of features (info within classes)
3. The inital part of this project will focus on creating a customer account page, where a user can add, updata, read and delete information such as, username, password, email, address
4. Packages for Domain, repo, Rest and Service created
5.CustomerAccount class populated with attributes, constructors, getters and setters and a to string
6.CustomerAccountController class populated with annotation for get request to check that server is working
7.Made CustomerAccountService into an interface to contain methods that must be deployed to classes that implement it, 
such as CustomerAccountServiceDB (which handles DB interactions)
8.Populated CustomerAccountRepo

//Create (on create_feature branch)
9.Adding create functionality to CustomerAccountService and implemented the method in CustomerAccountServiceDB,Post request added to CustomerAccountController class
10.Created a customer account, with name, email and dob in postman

//Read (on read_feature branch)
11.Added Read functionality to CustomerAccountService and implemented the methods in CustomerAccountServiceDB, Get request with ResponseEntity added to Controller
12.Created a series of customer accounts
13. Read all of the customer account information by using localhost:8080/customeraccount/getall in Postman
14. Read a specific customer acount using a customer id