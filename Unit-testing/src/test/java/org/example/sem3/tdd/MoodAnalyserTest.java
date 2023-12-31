package org.example.sem3.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MoodAnalyserTest {
    private MoodAnalyser moodAnalyser;

    @BeforeEach
    void setUp() {
        moodAnalyser = new MoodAnalyser();
    }

    @Test
    void analyseMood() {
        assertEquals("плохо", moodAnalyser.analyseMood("Чувствую себя неважно"));
        assertEquals("хорошо", moodAnalyser.analyseMood("У меня всё просто прекрасно!"));
        assertEquals("средне", moodAnalyser.analyseMood("Сегодня был сложный день"));
        assertEquals("не определено", moodAnalyser.analyseMood("Сегодня был простой день"));
    }
}