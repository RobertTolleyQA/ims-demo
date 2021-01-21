Coverage: 65%
# Project Title

This IML project is an sql database based project aimed at providing a command line interface to allow the user to input and alter customer,item & order details.

## Getting Started

1.Go to https://github.com/RobertTolleyQA/ims-demo  
2.Clone the repository onto your local drive  
	- git clone <url> on your pc  
3.Create an IMS database on Mysql  
4.(if using git to run java file) ----- Open git bash in the ims-demo/target  
	- type "java -jar https://github.com/RobertTolleyQA/ims-demo.jar  

### Prerequisites
1.Ensure java version 1.8 or higher is installed  
2.(optional) download git for your current OS  
3.Download Eclipse IDE for Enterprise Java Developers Version (4.16.0)  

### Using the jar

Enter your sql database username & password

```
What is your username:
root
What is your password:
root
```
Begin entering data for your data base  
IMPORTANT!  
Ensure you enter customer & item data before attempting to create an order  

```
CUSTOMER("Information about customers")  
ITEM("Individual Items")  
ORDER("Purchases of items")  
STOP("To close the application")  
```

Choose an option to use within each section  
Type 'return' to go back to main options  

```
CREATE("To save a new item into the database")  
READ("To read an item from the database")  
UPDATE("To change an item already in the database")  
DELETE("To remove an item from the database")  
RETURN("To return to domain selection")  
```
To stop running the program:  
1. Type 'stop' when viewing the main objects  
2. Type any of the options to close the program  

## Running the tests

1.Junit testing  
When on eclipse -- Right click the project or class -> Run As -> Junit Test  
2.Junit cover
When on eclipse -- Right click the project or class -> Coverage As -> Junit Test  
3.Testing specific packages or classes:  
-open src/test/java -> perform above actions   

### Unit Tests 

These tests test specific code that is only accessed in that class file and validate each unit.

```
src/test/java  
com.qa.ims.persistence.domain
```

### Integration Tests 
These tests test code that calls apon other methods that come from seperate classes, ensuring the are able to work with each other correctly.  

```
src/test/java  
com.qa.ims.controller
```


## Deployment

To allow this program to access live public databases:  
1. Open the com.qa.ims.utils
2. Open the DBUtils.java
3. Change the DB_URL from 'localhost' to the desired IP address  

```
private final String DB_URL = "jdbc:mysql://localhost:3306/ims";  
private final String DB_URL = "jdbc:mysql://197.0.0.0:3306/ims";
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

1.0.0

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Robert Tolley** - *Final work* - [roberttolley](https://github.com/RobertTolleyQA)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
