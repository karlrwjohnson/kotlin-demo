package demo.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        // Activate support for CORS headers
        http.cors()

        // Deactivate CSRF protection since we're not going to use Cookie authentication
        http.csrf().disable()

        http.authorizeRequests { auth ->
            // Basically disable security. It's a demo, alright?
            auth.anyRequest().permitAll()
        }
    }
}
