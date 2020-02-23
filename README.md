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
    "title": "Dziady cz.III",
    "author": "Adam Mickiewicz"
}
```
* GET all: /book/all
* GET one: /book/{book_id}
* POST create: /book/create
* PUT update: /book/update/{book_id}
* DELETE delete: /book/delete/{book_id}
##### Readers:
```json
{
    "name": "Adam",
    "surname": "Kowalski"
}
```
* GET all: /reader/all
* GET one: /reader/{reader_id}
* POST create: /reader/create
* PUT borrow book: /reader/{reader_id}/borrow/book/{book_id}
* PUT give back book: /reader/{reader_id}/giveBack/book/{book_id}
* PUT update: /reader/update/{reader_id}
* DELETE delete: /reader/delete/{reader_id}

## Compilation Command:
* `mvn spring-boot:run`
