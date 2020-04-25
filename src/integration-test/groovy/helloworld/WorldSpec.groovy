package helloworld

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
@Rollback
class WorldSpec extends Specification {

    def 'greet the world' () {

        when:
        World world = new World(greeting: "hello world").save()

        then:
        World.count == old(World.count) + 1
        World.exists(world.id)
    }
}
