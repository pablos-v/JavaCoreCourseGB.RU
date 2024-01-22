package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AverageCounterTest {

    @Test
    void findAverage() {
        int average = AverageCounter.findAverage(Arrays.asList(5, 5, 5, 5, 5));

        assertEquals(5, average);
    }
}