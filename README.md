# Spring Boot Testing
In this repository I present how spring boot framework help us to perfrom
unit and integration tests

I have divided this short presentation in the following parts:

    1. REST flow and layers defintions 
    2. My app: short presentation of my dummy app
    3. Unit testing: unit testing by using spring boot tools
        3.1 Unit testing the service layer
        3.2 Unit Testing the controller layer
        3.3 Unit testing the persistence layer
    4. Integration tesing
    5. Useful links
    
## 1. REST flow
Usually in a REST app the following steps are executed:

    1. Controller receives a message/object (JSON message, XML etc.)
    2. Controller sends this message for processing in the Service layer
    (this is where the business logic is executed)
    3. Most of the times the Service layer interacts with a Repository layer
    (the layer that keeps the persistent data, a database)
    4. After the Service layer executes a flow, then returns to controller a       response 

Somehow you want to test the main three layers (controller, service and repository) in isolation (unit testing), this is can be achieved easily by using some convenient methods that Spring Boot provides for us 


https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-te$
https://spring.io/guides/gs/testing-web/
http://www.baeldung.com/spring-boot-testing
https://dzone.com/articles/unit-and-integration-tests-in-spring-boot
https://thepracticaldeveloper.com/2017/07/31/guide-spring-boot-controller-tests/
