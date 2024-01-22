package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ResultPrinterTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testPrintWithZero() {
        ResultPrinter.print(0);

        assertEquals("Средние значения равны", outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintWithPositive() {
        ResultPrinter.print(10);

        assertEquals("Первый список имеет большее среднее значение", outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintWithNegative() {
        ResultPrinter.print(-2);

        assertEquals("Второй список имеет большее среднее значение", outputStreamCaptor.toString().trim());
    }
}