package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AverageCounterTest {

    @Test
    void findAverage() {
        ListGenerator generator = mock(ListGenerator.class);
        when(generator.generateRandomList(12)).thenReturn(Arrays.asList(5, 5, 5, 5, 5));

        List<Integer> ls = generator.generateRandomList(12);
        int average = AverageCounter.findAverage(ls);

        assertEquals(5, average);
    }
}