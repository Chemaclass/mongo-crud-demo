# A CRUD example using Spring + MongoDB

Result code from this Youtube video: https://youtu.be/ot-yPfaAQ_w

## Spring Boot

Go to https://start.spring.io/ and select:

* Gradle
* Java
* Dependencies: `Spring Web` and `Spring Data MongoDB` 


## Prepare the structure

Open the generated code from start.spring.io with InteliJ.

Create the structure of your CRUD:

* controller: is where your resources/endpoints will be placed. No business logic.
* entity: is where you should placed the mongodb documents
* repository: is where you will placed your repositories to access the data
* service: is where the business logic is placed. The layer between the controllers and the repositories.


