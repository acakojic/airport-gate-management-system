package org.airport.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity //!Compulsory TODO: read about this annotation
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();//In practice, this should not be disabled!
        httpSecurity.headers().frameOptions().disable(); //h2-console to not be blank page

        httpSecurity.
                authorizeRequests()
                .antMatchers(HttpMethod.GET, "/rest/gates").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/rest/gates/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/rest/flights/**").hasRole("USER")
                .antMatchers("/swagger-resources/**").hasRole("ADMIN")
                .antMatchers("/swagger-ui.html").hasRole("ADMIN")
                .antMatchers("/v2/api-docs").hasRole("ADMIN")
                .antMatchers("/webjars/**").hasRole("ADMIN")
                .antMatchers("/h2-console/**").hasRole("ADMIN")
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    // Create two users for demo
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER")
                .and()
                .withUser("admin").password("{noop}admin").roles("USER", "ADMIN");

    }

}
