# Contributing to Lucid-SAMS

When contributing towards the Lucid-SAMS API project, the user should always attempt to follow the best community
standards and practices as set out withing the current technology stack as defined in the Lucid-SAMS README and below.

# API Endpoints Contributions

The Lucid-SAMS API endpoints shall be defined int the `lucid-sams-services` module in the Lucid-SAMS source directory.

## Lucid-SAMS Services Module

When contributing API endpoints to this module the developer should at all times and to the best of their ability
attempt to write their API endpoints to achieve at the very least **_Level-2_** of
the [Richardson's Maturity Model for RESTful APIs](https://restfulapi.net/richardson-maturity-model/).

## Richardson's Maturity Model

This model is a division of REST services to identify their maturity level. Richardson used 3 factors to decide the
maturity of a service. Namely:

1. [Resource Naming (URI)](https://restfulapi.net/resource-naming/)
2. [HTTP Methods](https://restfulapi.net/http-methods/)
3. [Hypermedia (HATEOS)](https://restfulapi.net/hateoas/)

Richardson describes 4 maturity levels as below:

### 1. Level-0

The services at zero maturity level have a single URI and use a single HTTP method (typically POST).

For example, most SOAP Web Services use a single URI to identify an endpoint, and HTTP POST to transfer SOAP-based
payloads, effectively ignoring the rest of the HTTP verbs.

### 2. Level-1

The services at maturity level one employ many URIs but only a single HTTP verb – generally HTTP POST.

A resource can be a singleton or a collection.

For example, `customers` is a collection resource and `customer` is a singleton resource (in a banking domain).

We can identify `customers` collection resource using the URI `/customers`. We can identify a single `customer` resource
using the URI `/customers/{customerId}`.

A resource may contain sub-collection resources also.

For example, sub-collection resource `accounts` of a particular `customer` can be identified using the URI
`/customers/{customerId}/accounts` (in a banking domain).

Similarly, a singleton resource `account` inside the sub-collection resource `accounts` can be identified as follows:
`/customers/{customerId}/accounts/{accountId}`.

Lucid-SAMS School Example:

- `/schools`
- `/schools/{schoolId}`
- `/schools/{schoolId}/general-info`
- `/schools/{schoolId}/cycle-info`
- `/schools/{schoolId}/classes`
- `/schools/{schoolId}/classes/{classId}`

Resource path definitions should follow the standard of using `spinal-case` only when defining resource paths and should
not follow any other standard like`CamelCase` or `snake_case`.

### *NB! - The developer contributing to this module will be expected to achieve this level (Level-1) of the maturity model.

### 3. Level-2

The level two services generally host numerous URIs i.e. addressable resources.

Such services support several of the HTTP verbs and codes on each exposed resource – Create, Read, Update and Delete (
CRUD) services. Here the state of resources, typically representing business entities, can be manipulated over the
network. REST guidelines suggest using a specific HTTP method on a particular type of call made to the server with the
correct response code to indicate the status of the attempted call.

CRUD base HTTP methods are as follows:

1. [HTTP GET](https://restfulapi.net/http-methods/#get)
2. [HTTP POST](https://restfulapi.net/http-methods/#post)
3. [HTTP PUT](https://restfulapi.net/http-methods/#put)
4. [HTTP DELETE](https://restfulapi.net/http-methods/#delete)
5. [HTTP PATCH](https://restfulapi.net/http-methods/#patch)

Maturity level 2 is the most popular use case of REST principles, which advocate using different verbs based on the HTTP
request methods, while the system can have multiple resources.

Lucid-SAMS School example to perform CRUD operations:

HTTP POST:

- `HTTTP POST` - `/schools` (Create a school)
- `HTTP POST` - `/schools/{schoolId)/classes` (Create class for a singleton school)

HTTP GET:

- `HTTP GET` - `/schools`(Retrieve collection of schools)
- `HTTP GET` - `/schools/{schoolId)` (Retrieve singleton school)
- `HTTP GET` - `/schools/{schoolId)/classes` (Retrieve class collection for a singleton school)
- `HTTP GET` - `/schools/{schoolId)/classes/{classId}` (Retrieve singleton class for a singleton school)

HTTP PUT:

- `HTTP PUT` - `/schools/{schoolId)` (Update singleton school)

HTTP DELETE:

- `HTTP DELETE` - `/schools/{schoolId)` (Delete singleton school)

The use of HTTP response code to indicate the status of the API request should be used based on the status, here are

References on when to use the correct status code to indicate the request status:

1. [Informational Responses  (100–199)](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#information_responses)
2. [Successful Responses (200–299)](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#successful_responses)
3. [Redirection Messages (300–399)](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#redirection_messages)
4. [Client side error responses (400–499)](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#client_error_responses)
5. [Server side error responses (500–599)](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#server_error_responses)

**_*NB! - Note the following examples are pseudocode examples used to show how Level-2 with the correct use of resource
path naming, HTTP methods and HTTP status codes can be implemented using Java and Spring Boot. These code examples
should not be used in the actual implementation but only as a reference on how to achieve the implementation._**

Spring Boot code examples:

#### Controllers:

Controllers should be defined with the name of the specific business entity that the scope of the controller will deal
with i.e the example below references school entity actions. The resource path of the controller should always make
reference to a collection of those entities, in this case `/schools`.

```java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The resource is defined by naming the controller with the name of the business entity handled in this scope.
 *
 * @see RequestMapping is defined using the reference to a collection of entities (i.e /schools). This will also define
 * the base resource path for this controller, from which all schools endpoints can be derived from.
 */
@RestController
@RequestMapping("/schools")
public class SchoolController {
}
```

#### Controller API Endpoints

- `HTTP POST /schools` (Create a school)
- `HTTP POST /schools/{schoolId}/classes` (Create a class for singleton school)
- `HTTP DELETE /schools/{schoolId}/classes/{classId}` (Remove singleton class from school)
- `HTTP GET /schools` (Retrieve school collection)
- `HTTP GET /schools/{schoolId}` (Retrieve singleton school)

```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    /**
     * This endpoint will create a school with the values defined in the request body.
     *
     * HTTP POST /schools
     *
     * @param request the request body representing the values required to create a school
     * @return the created school response body with the "created" HTTP status code (201).
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateSchoolResponse> createSchool(@RequestBody CreateSchoolRequest request) {
        CreateSchoolResponse response = schoolService.createSchool(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    /**
     * This endpoint will create a school's class with the values defined in the request body.
     *
     * HTTP POST /schools/{schoolId}/classes
     *
     * @param request the request body representing the values required to create a school's class
     * @return the created class response body with the "created" HTTP status code (201).
     */
    @PostMapping(
            path = "/{schoolId}/classes",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CreateClassResponse> createClass(@RequestBody CreateClassRequest request,
                                                           @RequestParam String schoolId) {
        CreateClassResponse response = schoolService.createClass(request, schoolId);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    /**
     * This endpoint will remove a school's class.
     *
     * HTTP DELETE /schools/{schoolId}/classes/{classId}
     *
     * @param schoolId the identifier of the school for which the class is to be removed.
     * @param classId the identifier of the class which is to be removed.
     * @return the response with the "no content" HTTP status code (204).
     */
    @DeleteMapping(
            path = "/{schoolId}/classes/{classId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<void> removeClass(@RequestParam String schoolId,
                                            @RequestParam String classId) {
        schoolService.removeClass(request, schoolId);
        return ResponseEntity.noContent();
    }

    /**
     * This endpoint will retrieve all schools.
     *
     * HTTP GET /schools
     *
     * @return the collection of schools with the "ok" HTTP status code (200).
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<School>> retrieveSchools() {
        List<School> response = schoolService.retrieveSchools(request);
        return ResponseEntity.ok(response);
    }

    /**
     * This endpoint will retrieve a singleton school.
     *
     * HTTP GET /schools/{schoolId}
     *
     * @param schoolId is the identifier of the school to be retrieved. 
     * @return the singleton school with the "ok" HTTP status code (200).
     */
    @GetMapping(
            path = "/{schoolId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<School>> retrieveSchools(@RequestParam String schoolId) {
        School response = schoolService.retrieveSchools(schoolId);
        return ResponseEntity.ok(response);
    }
}
```

### *NB! - The developer contributing to this module will be expected to achieve this level (Level-2) of the maturity model.

### 4. Level-3

[//]: # (TODO: Document how the developer can achieve a level-3 restful API maturity.)
_// Still to be documented._

## Technology Stack

- Java: 8
- Springboot: 2.4.4
- Springfox-swagger: 2.9.2