package com.yt.javabrains.springsecuritybasics.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager configureUserDetails() {
        UserDetails userDetails1 = createNewUser("user11","password1","USER");
        UserDetails userDetails2 = createNewUser("user2","password2","USER");
        UserDetails userDetails3 = createNewUser("user3","password3","USER");
        return new InMemoryUserDetailsManager(userDetails1,userDetails2,userDetails3);
    }

    private static UserDetails createNewUser(String userName,String password,String role) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(userName)
                .password(password)
                .roles(role)
                .build();
        return userDetails;
    }

    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
