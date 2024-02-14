package org.example.startertimer;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableConfigurationProperties(TimerProps.class)
public class StarterTimerConfiguration {
    @Bean
    TimerAspect timer() {
        return new TimerAspect();
    }

}
