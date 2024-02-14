package org.example.startertimer;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data // getter + setter
@ConfigurationProperties("http.logging")
public class TimerProps {
}
