1.Created repo on desktop for ecommerce backend and linked it to my github
2.Created dev and features branch. Dev will be used for the creation of classes, features will be used for the creation of features (info within classes)
3. The inital part of this project will focus on creating a customer account page, where a user can add, updata, read and delete information such as, username, password, email, address
4. Packages for Domain, repo, Rest and Service created
5.CustomerAccount class populated with attributes, constructors, getters and setters and a to string
6.CustomerAccountController class populated with annotation for get request to check that server is working
7.Made CustomerAccountService into an interface to contain methods that must be deployed to classes that implement it, 
such as CustomerAccountServiceDB (which handles DB interactions)
8.Populated CustomerAccountRepo class which is inherits the methods in JpaRepository

//Create (on create_feature branch)
9.Adding create functionality to CustomerAccountService and implemented the method in CustomerAccountServiceDB,Post request added to CustomerAccountController class
10.Created a customer account, with name, email and dob in postman
postman entry: localhost:8080/customeraccount/create

{
	"name":"John Smith"
	"email":"J.Smith@yahoo.com"
	"dob" : "2000-01-11"
}

//Read (on read_feature branch)
11.Added Read functionality to CustomerAccountService and implemented the methods in CustomerAccountServiceDB, Get request with ResponseEntity added to Controller
12. Created a series of customer accounts (in postman)
13. Read all of the customer account information by using localhost:8080/customeraccount/getall in Postma
14. Read a specific customer acount using a customer id

//Update (on update_feature branch)
15. Added Update functionality to CustomerAccountService and implemented method in CustomerAccountServiceDB, Put request with ReponseEntity added to Controller
16.Created a series of customer accounts (in postman)
17.Updated a specic customer account using a customer id

//Delete (on delete_feature branch)
18. Added DELETE functionality to CustomerAccountService and implemented method in CustomerAccountServiceDB, Delete request with ReponseEntity added to Controller
19.Created a series of customer accounts (in postman)
20.Deleted a specic customer account using a customer id