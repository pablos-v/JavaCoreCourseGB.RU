package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    void main() {
        System.setOut(new PrintStream(outputStreamCaptor));
        String resultOne = "Первый список имеет большее среднее значение";
        String resultTwo = "Второй список имеет большее среднее значение";
        String resultThree = "Средние значения равны";

        App.main(null);
        String actual = outputStreamCaptor.toString().trim();

        assertTrue(actual.equals(resultOne) || actual.equals(resultTwo) || actual.equals(resultThree));
    }
}