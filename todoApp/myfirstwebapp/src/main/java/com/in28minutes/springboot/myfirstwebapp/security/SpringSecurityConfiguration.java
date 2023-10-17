package com.in28minutes.springboot.myfirstwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    //LDAP or Database
    //In Memory

    //InMemoryUserDetailsManager
    //InMemoryUserDetailsManager(UserDetails... users)

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {

        UserDetails userDetails1 = createNewUser("kyungmin", "sun");
        UserDetails userDetails2 = createNewUser("ranga", "dummydummy");

        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER","ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //1. All URLs are protected (모든 URL 보호)
    //2. A login form is shown for unauthorized requests (승인되지 않은 요청에 대해서는 로그인 양식이 표시)
    //3. CSRF disable (CSRF 비활성화)
    //4. Frames (프레임)

    // SecurityFilterChain : 웹요청이 들어오면 언제나 먼저 이 체인이 그것을 처리
    // 원래 이 체인은 위의 1,2번을 기본으로 처리하는데 밑 코드에서 3,4 번 추가 처리
    // SecurityFilterChain 는 오버라이드한것이므로 재정의 필요
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 승인을 어떻게 할 것인가를 구현
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
        // formLogin 을 통해 사용자 이름과 패스워드를 수집할 수 있는 페이지를 표시할 수 있게 함
        http.formLogin(withDefaults());

        // csrf 를 비활성화
        http.csrf(csrf -> csrf.disable());
        // OR
        // http.csrf(AbstractHttpConfigurer::disable);

        http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)); // Starting from SB 3.1.x

        return http.build();
    }

}