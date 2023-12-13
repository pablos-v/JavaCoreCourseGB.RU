package com.pablos.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.pablos.spring.security")
@EnableWebMvc
public class MyConfig {
    @Bean // префикс и суффикс для jsp страниц
    public ViewResolver vievResolver(){
        return new InternalResourceViewResolver("/WEB-INF/view/",".jsp");
    }
}
