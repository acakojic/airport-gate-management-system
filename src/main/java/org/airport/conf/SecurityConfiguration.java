package org.airport.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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

        httpSecurity.
                authorizeRequests().antMatchers(HttpMethod.GET).hasRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST).hasRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.PUT).hasRole("ADMIN")
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        String[] AUTH_WHITELIST = {
                "/swagger-resources/**",
                "/swagger-ui.html",
                "/v2/api-docs",
//                "/webjars/**",
                "/h2-console/**"
        };

        web.ignoring().antMatchers(AUTH_WHITELIST);
    }

}
