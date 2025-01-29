# spring-boot-rest-api-example

This is an example of using Spring Boot to build REST API.

Swagger UI: http://localhost:8080/swagger-ui/index.html

OpenAPI specification: http://localhost:8080/v3/api-docs

## Data Transfer Object (DTO)

A DTO is an object that carries data between processes. DTOs are used to transfer data between the client and the server, or between different layers of the application. They help in decoupling the internal representation of data from the data that is exposed through the API, providing more flexibility and security.

By using DTOs, you can control the data that is exposed through the API, hide sensitive information, and change the internal representation of data without affecting the API contract.

## Pagination 

Pagination is used to limit the size of returned result of getting all books.

## Test the API

GET: http://localhost:8080/api/books

GET: http://localhost:8080/api/books?page=0&size=10&sort=title,asc

POST: http://localhost:8080/api/books

```
{
 "title": "dummy book",
 "author": "dummy author",
 "isbn": "111"
}
```

GET: http://localhost:8080/api/books/1

PUT: http://localhost:8080/api/books/1

```
{
 "title": "dummy book",
 "author": "dummy author",
 "isbn": "222"
}
```

DELETE: http://localhost:8080/api/books/1
