package com.example.usecase.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {




    private static final String[] SECURED_URLs_FOR_ADMIN = {"/api/v1.0/shopping/add",

                                                        "/api/v1.0/shopping/update/{id}",
                                                        "/api/v1.0/shopping/delete/{id}"};

    private static final String[] SECURED_URLs_FOR_CUSTOMER = {
            "/api/v1.0/shopping/products/search/{productName}",

            };

    private static final String[] UN_SECURED_URLs = {

            "/api/v1.0/shopping/public",
            "/api/v1.0/shopping/register",
            "/api/v1.0/shopping/login",
            "/api/v1.0/shopping/forgot",
            "/api/v1.0/shopping/role/{user}"
    };


    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http.cors().and().csrf().disable()
                .authorizeHttpRequests()
                .antMatchers(UN_SECURED_URLs)
                .permitAll()
                .antMatchers("/api/v1.0/shopping/demo").hasAuthority("CUSTOMER")
                .antMatchers(SECURED_URLs_FOR_ADMIN)
                .hasAuthority("ADMIN")
                .antMatchers(SECURED_URLs_FOR_CUSTOMER)
                .hasAuthority("CUSTOMER")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic().and().build();
    }

}