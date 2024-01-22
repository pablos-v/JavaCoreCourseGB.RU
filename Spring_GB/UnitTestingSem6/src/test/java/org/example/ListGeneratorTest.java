package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ListGeneratorTest {

    @Test
    void generateRandomListTestLength() {
        ListGenerator generator = new ListGenerator();

        List<Integer> ls = generator.generateRandomList(5);

        assertEquals(5, ls.size());
    }
}