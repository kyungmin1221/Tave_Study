package com.in28minutes.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    // 사용자 이름과 pwd를 저장하려고 할 때는 LDAP 또는 데이터베이스를 사용

//    InMemoryUserDetailsManager
//    public InMemoryUserDetailsManager() { /* compiled code */ }

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        Function<String,String> passwordEncorder
                =input -> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()
                                    .passwordEncoder(passwordEncorder)
                                    .username("kyungmin")
                                    .password("sun")
                                    .roles("USER","ADMIN")
                                    .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
