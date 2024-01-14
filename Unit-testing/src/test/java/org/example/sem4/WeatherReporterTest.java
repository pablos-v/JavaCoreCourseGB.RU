package org.example.sem4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherReporterTest {

    @Test
    void generateReport() {
        WeatherService service = mock(WeatherService.class);
        when(service.getCurrentTemperature()).thenReturn(25);
        WeatherReporter reporter = new WeatherReporter(service);

        String res = reporter.generateReport();

        assertEquals("Текущая температура: 25 градусов.", res);

    }
}