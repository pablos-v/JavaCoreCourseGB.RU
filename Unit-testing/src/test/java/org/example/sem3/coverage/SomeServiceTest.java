package org.example.sem3.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    SomeService obj;

    @BeforeEach
    void setUp() {
        obj = new SomeService();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9})
    void multipleThreeNotFiveReturnsFizz(int n) {
        assertEquals("Fizz", obj.fizzBuzz(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 50})
    void multipleFiveNotThreeReturnsBuzz(int n) {
        assertEquals("Buzz", obj.fizzBuzz(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 45, 30, 0})
    void multipleFifteenReturnsFizzBuzz(int n) {
        assertEquals("FizzBuzz", obj.fizzBuzz(n));
    }

    @Test
    void returnsNull() {
        assertNull(obj.fizzBuzz(4));
    }

    @ParameterizedTest
    @ArgumentsSource(ArraysArgumentsProvider.class)
    void firstLast6WorksCorrectly(int[] ls) {
        assertTrue(obj.firstLast6(ls));
    }

    static class ArraysArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(new int[]{1, 3, 6}),
                    Arguments.of(new int[]{6, 5, 5})
            );
        }
    }

    @ParameterizedTest
    @CsvSource({
            "500, 20",
            "800, 50"
    })
    void discountCalculateCheck(double price, int discount) {
        assertEquals(400d, obj.calculatingDiscount(price, discount));
    }

    @ParameterizedTest
    @CsvSource({
            "13, 25, 60",
            "80, 5, 13"
    })
    void sumNot13Check(int a, int b, int c) {
        assertEquals(85, obj.sumNot13(a, b, c));
    }
}