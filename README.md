# airport-gate-management-system
Demo airport-gate-management-system

# Assumption of Business Logic
Each Gate can have park zero or only one Airplane, i.e. Gate to Aiplane is a bidirectional `OneToOne` relationship

# Environment Requirement
* Internet connection
* Preferably GNU/Linux with Maven, Curl and Java 8 (Compiler and JRE)

# How to Compile and Run
`cd` to this project home directory, where pom.xml is located
* Compile with command: `mvn clean package -DskipTests`
* Run With command: `java -jar target/airport-gate-management-system.jar`

# Technology used
* Spring Boot with Java 8
* Hibernate JPA, JPQL
* Spring Security
* H2 embedded in-memory database with its SQL Dialect for inserting initial data (just for testing purpose)

# REST API Description 
GET, PUT request is secured with username `admin` and password `admin` and CSRF disabled just for testing purpose
* List of all REST API Description: 'http://localhost:8080/swagger-ui.html'
* List all Gates: `GET http://localhost:8080/rest/gates`
* Update existing Gate (identified by id): `PUT http://localhost:8080/rest/gates/{id}`
* Get specific Flight and park it to Gate if available (by flight_id): `GET http://localhost:8080/rest/flights/{id}/park`
* Add a new Reservation: `POST http://localhost:8080/rest/reservations`

# Example commands to test with Curl
* List all Gates: `curl -v -H "Content-Type: application/json" -X GET -u "admin:admin" http://localhost:8080/rest/gates`
* Update specific Gate:
    * `curl -v -H "Content-Type: application/json" -X PUT -u "admin:admin" -d '{"name" : "gate01", "status" : "CLOSED"}' http://localhost:8080/rest/gates/1`
    * `curl -v -H "Content-Type: application/json" -X PUT -u "admin:admin" -d '{"name" : "gate01", "status" : "OPEN"}' http://localhost:8080/rest/gates/1`  
    * (without authentication, thus expected to fail) `curl -v -H "Content-Type: application/json" -X PUT -d '{"name" : "gate01", "status" : "CLOSED"}' http://localhost:8080/rest/gates/1`

* Get specific Flight and park(update) it to Gate if available (by flight_id): 
    * `curl -v -H "Content-Type: application/json" -X GET -u "user:user" http://localhost:8080/rest/flights/1/park`
    * `curl -v -H "Content-Type: application/json" -X GET -u "user:user" http://localhost:8080/rest/flights/2/park`
  
* Add new reservation:
    * `curl -v -H "Content-Type: application/json" -X POST -u "user:user" -d '{"time_from":"2014-01-01T11:00:00","time_to":"2014-01-01T22:00:00"}' http://localhost:8080/rest/reservations`



