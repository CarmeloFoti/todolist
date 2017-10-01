# TODO list

This is a basic TODO list web application, implemented using a REST endpoint written with Spring framework and an AngularJS frontend

## Getting Started

To clone the project use the following command:
```
git clone https://github.com/CarmeloFoti/todolist.git
```
### Prerequisites

In order to run the project, you need Java 1.8 installed on your machine. 

If you want to run it in production mode you will need an instance of Mysql up and running


### Installing

Once you cloned the project, get in the right folder:

```
cd todolist
```

And package the executable:

```
mvn package
```


## Running the application

You can launch the application using spring boot:
```
mvn spring-boot:run
```
If the run is successful, you will se the following output:
```
.................
.................
it.melo.todolist.TodolistApplication     : Started TodolistApplication in 3.713 seconds (JVM running for 4.005)
```

You can now navigate to [http://localhost:8080](http://localhost:8080/) and test the app.

### Config: local vs production
There are two different profiles (see [src/main/resources/application.yml](src/main/resources/application.yml) for details).

During development profile "default" is used: An in-memory database is created at every run, and dropped at shutdown.

Using the "prod" profile, the application will try to connect to a local instance of Mysql (configuration is declared in application.yml)
To run the application in production mode use: 
```
mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=prod"
```


## Deployment
In order to make deployment easier, a Dockerfile is provided.
Since the whole app is encapsulated in a single Jar file, the Dockerfile is very simple.

run ```docker build . ``` to create the image, and run it using ```docker run -p 8080:8080 -i -t [image_id]```



## Built With

* [SpringIO](https://spring.io/) - The Java framework used
* [AngularJS](https://angularjs.org/) - The Web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Bootstrap](http://getbootstrap.com/) - Used to get a basic UI


## Authors

* **Carmelo Foti** - *First release* 


## License

This project is licensed under the MIT License

## Acknowledgments

* my nespresso machine
