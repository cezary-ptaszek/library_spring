# Library
### Description
Basic project of the library. It contains books which can be borrowed by readers. Program includes CRUD functions. All data are saved in an external database.

## Technologies:
* Java 8
* Spring Boot 2.1.5
* Spring Data JPA with Hibernate 5.3.10
* JUnit 4.12
* Maven 3.6.0
* mySQL 8 running online
* IntelliJ IDEA 2018.3.2
* Git 2.20.1

## Endpoints:
##### Books:
```json
{
    "id": 31,
    "title": "Dziady cz.III",
    "author": "Adam Mickiewicz",
    "reader": null
}
```
* GET all: /book/all
* GET one: /book/{id}
* POST create: /book/create
* POST update: /book/update/{id}
* DELETE delete: /book/delete/{id}
##### Readers:
```json
{
	"id": 21,
	"name": "Adam",
	"surname": "Kowalski"
}
```
* GET all: /reader/all
* GET one: /reader/{id}
* POST create: /reader/create
* POST borrow book: /reader/{readerId}/borrow/book/{bookId}
* POST give back book: /reader/{readerId}/giveBack/book/{bookId}
* POST update: /reader/update/{id}
* DELETE delete: /reader/delete/{id}

## Compilation Command:
* `mvn spring-boot:run`

## #Test project, not complete
