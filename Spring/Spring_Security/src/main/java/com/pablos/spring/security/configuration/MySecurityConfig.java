package com.pablos.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class MySecurityConfig{
    // банальный вариант аутентификации, без кодировки и БД, для демонстрации
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("pablos")
//                .password("pablos")
//                .roles("EMPLOYEE")
//                .build();
//        UserDetails user2 = User.withDefaultPasswordEncoder()
//                .username("ivan")
//                .password("ivan")
//                .roles("HR", "MANAGER")
//                .build();
//        UserDetails user3 = User.withDefaultPasswordEncoder()
//                .username("olga")
//                .password("olga")
//                .roles("SALES")
//                .build();
//        return new InMemoryUserDetailsManager(user, user3, user2);
//    }

    // вариант аутентификации с кодировкой пароля в памяти
    @Bean
    public BCryptPasswordEncoder encoder(){return new BCryptPasswordEncoder();}

    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder encoder){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("pablos")
                .password(encoder.encode("pablos"))
                .roles("EMPLOYEE")
                .build());
        manager.createUser(User.withUsername("ivan")
                .password(encoder.encode("ivan"))
                .roles("HR")
                .build());
        manager.createUser(User.withUsername("sveta")
                .password(encoder.encode("sveta"))
                .roles("MANAGER", "HR")
                .build());
        return manager;
    }

    // авторизация по ролям
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((user) -> user
                .requestMatchers(new AntPathRequestMatcher("/")).hasAnyRole("HR", "MANAGER", "IT", "EMPLOYEE")
                // /manager_info/** сама папка и всё что вложено в папку /manager_info
                .requestMatchers(new AntPathRequestMatcher("/manager_info/**")).hasRole("MANAGER")
                .requestMatchers(new AntPathRequestMatcher("/hr_info/**")).hasRole("HR")
                .anyRequest().authenticated())
            .formLogin(Customizer.withDefaults());
        return http.build();
    }
}
