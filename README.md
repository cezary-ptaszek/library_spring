# Library
### Description
Basic project of the library with REST_API. It contains books which can be borrowed by readers. Program includes basic CRUD functions. All datas are saved in an external database.

## Technologies:
* Java 8
* Spring Boot 2.1.5
* Spring Data JPA with Hibernate 5.3.10
* Maven 3.6.0
* mySQL 8 running online
* InteliJ IDEA 2018.3.2
* Git 2.20.1

## Endpoints:
##### Books:
```json
{
    "id": 31,
    "title": "Dziady cz.III",
    "author": "Adam Mickiewicz",
    "readerId": null
}
```
* main: /book/all
* get one: /book/{id}
* create: /book/create
* update: /book/update/{id}
* delete: /book/delete/{id}
##### Readers:
```json
{
	"id": 21,
	"name": "Adam",
	"surname": "Kowalski"
}
```
* main: /reader/all
* get one: /reader/{id}
* create: /reader/create
* borrow book: /reader/{readerId}/borrow/book/{bookId}
* give back book: /reader/{readerId}/giveBack/book/{bookId}
* update: /reader/update/{id}
* delete: /reader/delete/{id}

## Compilation Command:
* `mvn spring-boot:run`
