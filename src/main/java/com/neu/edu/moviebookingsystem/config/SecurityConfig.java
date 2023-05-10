package com.neu.edu.moviebookingsystem.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                authorizationManagerRequestMatcherRegistry.antMatchers("/home").permitAll();// hasAnyRole("ADMIN", "USER");
                authorizationManagerRequestMatcherRegistry.antMatchers("/book").hasAnyRole("USER");
                authorizationManagerRequestMatcherRegistry.antMatchers("/admin/*/*","/admin/*").hasAnyRole("ADMIN");
                authorizationManagerRequestMatcherRegistry.antMatchers("/screens/*").hasAnyRole("USER");
                authorizationManagerRequestMatcherRegistry.antMatchers("/register").permitAll();
        }).csrf().disable();
        httpSecurity.formLogin().loginPage("/login");

        httpSecurity.logout(httpSecurityLogoutConfigurer -> {
            httpSecurityLogoutConfigurer.logoutSuccessUrl("/login?signout=true");
            httpSecurityLogoutConfigurer.invalidateHttpSession(true);
        });

        return httpSecurity.build();

    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT username, password, active FROM user WHERE username=?"
        );
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT u.username, u.roles\n"
                        + "FROM user u\n"
                        + "WHERE u.username=?"
        );

        return jdbcUserDetailsManager;
    }
}
