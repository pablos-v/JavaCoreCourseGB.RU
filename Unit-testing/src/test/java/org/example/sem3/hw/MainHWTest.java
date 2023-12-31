package org.example.sem3.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MainHWTest {
    private MainHW clazz;

    @BeforeEach
    void setUp() {
        clazz = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4, 6})
    void testEvenOddNumberWithEven(int n) {
        assertTrue(clazz.evenOddNumber(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 11})
    void testEvenOddNumberWithOdd(int n) {
        assertFalse(clazz.evenOddNumber(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 100, -3, 0})
    void checkNumIntervalFalse(int n) {
        assertFalse(clazz.checkNumInterval(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {28, 31, 99, 26})
    void checkNumIntervalTrue(int n) {
        assertTrue(clazz.checkNumInterval(n));
    }
}