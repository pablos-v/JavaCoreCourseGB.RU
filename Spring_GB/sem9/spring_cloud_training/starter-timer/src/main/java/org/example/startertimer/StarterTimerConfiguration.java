package org.example.startertimer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TimerProps.class)
@ConditionalOnProperty(value = "http.timer.enabled", havingValue = "true")
public class StarterTimerConfiguration {
    @Bean
    TimerAspect timer(TimerProps props) {
        return new TimerAspect(props);
    }

}
