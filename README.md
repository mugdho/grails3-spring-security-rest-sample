# Grails 3 Spring Security Rest starter

**WORK IN PROGRESS. PLEASE DON'T REFER TO THIS YET**

This application provides the boilerplate code for starting a spring security with rest application. The spring security
rest plugin provides an easy way for pure RESTful services to be built quickly and uses [JWT](https://jwt.io) as the mode
of token interchange.

## Dependencies
* Java 8
* Grails 3.1.6
* Database - Any

Note: This is a REST only app and doesnt have any HTML or JS assets.

## Running
* If Grails 3.1.6 is installed then ``> grails run-app``
* If just gradle is installed then ``> gradle bootRun``
* If using gradlew then ``> ./gradlew bootRun``
* Default user is "user" and password "password" with role ADMIN.
* Database is defaulted to h2, but the application supports Postgres.
* The sole secured controller with this code is the Info controller which can be accessed at http://localhost:8080/info
* All paths in this application are secured using REST, but more customization can be made in conf/application.groovy