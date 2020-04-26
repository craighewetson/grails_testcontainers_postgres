package helloworld;

import org.testcontainers.containers.PostgreSQLContainer;

public class ConcretePostgreSQLContainer extends PostgreSQLContainer<ConcretePostgreSQLContainer> {
    ConcretePostgreSQLContainer(String dockerImageName) {
        super(dockerImageName);
        addFixedExposedPort(POSTGRESQL_PORT,POSTGRESQL_PORT);

    }

    ConcretePostgreSQLContainer() {
        super();
        addFixedExposedPort(POSTGRESQL_PORT,POSTGRESQL_PORT);
    }
}
