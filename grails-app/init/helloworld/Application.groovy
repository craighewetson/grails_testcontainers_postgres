package helloworld

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

import groovy.transform.CompileStatic
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration

@CompileStatic
//This annotation is needed to avoid an issue
@EnableAutoConfiguration(excludeName = ['com.playtika.test.postgresql.EmbeddedPostgreSQLDependenciesAutoConfiguration'])
class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }
}