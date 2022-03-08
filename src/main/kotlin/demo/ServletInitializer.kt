package demo

import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

// Entry point for running inside of a Servlet container
class ServletInitializer : SpringBootServletInitializer() {
    override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder {
        // "builder" is a Spring-provided object to configure the servlet
        // We need to tell it where the application root is.
        return builder.sources(App::class.java)
    }
}
