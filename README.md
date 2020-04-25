# Grails 4 + testcontainers-spring-boot + postgres 
This project is to demonstate the usage of testcontainers-spring-boot and postgressql with the Grails 4 framework.

The point on this is to avoid having to run integration tests using H2 but rather using postgresql within a docker container (via testcontainers)

## How to run:
`./gradlew clean integrationTest`
OR
via IDE

## Problem
It does not seem possible to get the properties that get exposed by `com.playtika.testcontainers:embedded-postgresql`
* embedded.postgresql.host
* embedded.postgresql.port
* embedded.postgresql.user
* embedded.postgresql.password

from the spring-cloud bootstrap context injected into the *application.yml*.

Either these properties are not accessible to get them injected OR they are, but cannot be injected into yml file.
I suspect the former (after debugging framework etc)

## Proposed solution
Inject these properties as system properties and then reference them within the application.yml as:
* EMBEDDED_POSTGRESQL_HOST
* EMBEDDED_POSTGRESQL_PORT
* EMBEDDED_POSTGRESQL_USER
* EMBEDDED_POSTGRESQL_PASSWORD

Example of usage:
`
url: jdbc:postgresql://${EMBEDDED_POSTGRESQL_HOST}:${EMBEDDED_POSTGRESQL_PORT}/test_db
username: '${EMBEDDED_POSTGRESQL_USER}'
password: '${EMBEDDED_POSTGRESQL_PASSWORD}'
`

Snippet take from [application.yml](./grails-app/config/application.yml) 


A *PR* for this solution has been made:

https://github.com/testcontainers/testcontainers-spring-boot/pull/251




