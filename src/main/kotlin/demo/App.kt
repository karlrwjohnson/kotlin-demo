package demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * The "application" as far as Spring Framework is concerned.
 *
 * In non-"Boot" Spring Framework you attach annotations to this class to tell it which features to enable
 * But Spring Boot does a lot of things by default depending on which plugins you've included
 * (e.g. when the Spring Boot MVC library is present, Boot automatically activates support for REST APIs)
 * So in our case, it's an empty object.
 *
 * The one thing it really gives us is defining where the "top package" is for when Spring starts scanning
 * for components annotated with `@Service` or  `@Repository`
 */
@SpringBootApplication
class App

// Entry point for running locally
fun main(args: Array<String>) {
    runApplication<App>(*args)
}
