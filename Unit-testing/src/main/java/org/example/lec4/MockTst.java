package org.example.lec4;


import org.mockito.Mock;

import java.util.LinkedList;

import static org.mockito.Mockito.*;

public class MockTst {


    public static void main(String[] args) {
        LinkedList mockedLinkedList = mock(LinkedList.class);
        when(mockedLinkedList.get(0)).thenReturn("nullValue");
        when(mockedLinkedList.get(1)).thenThrow(new RuntimeException("blaBLAbla"));
        // Выведет "nullValue"
        System.out.println(mockedLinkedList.get(0));
        // Вернет исключение runtime exception
        System.out.println(mockedLinkedList.get(1));
        // Если mockedLinkedList.get(0) не будет вызван до этой проверки, то тест провалится
        verify(mockedLinkedList).get(0);
    }
}
