package org.example.sem4;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PracticeTests {
    @Test
    public void iteratorReturnsHW(){
        Iterator iteratorMock = mock(Iterator.class);
        when(iteratorMock.next()).thenReturn("Hello").thenReturn("World");

        String result = iteratorMock.next() + " " + iteratorMock.next();

        assertEquals("Hello World", result);
    }
}
