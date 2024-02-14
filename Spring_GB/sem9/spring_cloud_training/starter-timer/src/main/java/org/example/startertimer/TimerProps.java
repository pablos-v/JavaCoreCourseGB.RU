package org.example.startertimer;

import lombok.Data;
import org.slf4j.event.Level;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("http.timer")
public class TimerProps {

    private Level logLevel = Level.DEBUG;

    private TimeCounting timeCounting = TimeCounting.MILLISECONDS;

}
