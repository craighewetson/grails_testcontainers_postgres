# Grails 4 + testcontainers + postgres without H2
This project is to demonstate the usage of testcontainers-spring-boot and postgressql with the Grails 4 framework.

The point on this is to avoid having to run integration tests using H2 but rather using postgresql within a docker container (via testcontainers)

Note that postgressql is the database I happen to choose, but you can replace it with another database that is supported by testcontainers.  

## How to run:
`./gradlew clean integrationTest`
OR
via IDE




