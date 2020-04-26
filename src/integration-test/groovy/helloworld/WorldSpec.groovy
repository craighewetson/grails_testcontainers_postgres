package helloworld

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

@Integration
@Rollback
@Testcontainers
class WorldSpec extends Specification {

    @Shared
    PostgreSQLContainer postgreSQLContainer = new ConcretePostgreSQLContainer();

    def 'greet the world'() {

        when:
        World world = new World(greeting: "hello world").save()

        then:
        World.count == old(World.count) + 1
        World.exists(world.id)
    }
}
