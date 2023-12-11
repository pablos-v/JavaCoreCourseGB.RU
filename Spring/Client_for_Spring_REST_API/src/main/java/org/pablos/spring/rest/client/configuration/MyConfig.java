package org.pablos.spring.rest.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
@ComponentScan("org.pablos.spring.rest.client")
public class MyConfig {
    @Bean
    // RestTemplate предоставляется СПРИНГом для совершения HTTP запросов
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
