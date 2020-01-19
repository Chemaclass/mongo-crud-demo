# A CRUD example using Spring + MongoDB

Result code from this Youtube video: https://youtu.be/ot-yPfaAQ_w

## Spring Boot

Go to https://start.spring.io/ and select:

* Gradle
* Java
* Dependencies: `Spring Web` and `Spring Data MongoDB` 

## Prepare the structure

Open the generated code from start.spring.io with IntelliJ.

Create the structure of your CRUD:

* controller: where your resources/endpoints will be placed. No business logic.
* entity: where you should place the MongoDB documents
* repository: where you will place your repositories to access the data
* service: where the business logic is placed. The layer between the controllers and the repositories.
