package org.example.lec4;

import org.mockito.Mockito;

import java.util.List;
public class Main {
    public static void main(String[] args) {
// Создание mock
        List mockedList = Mockito.mock(List.class);
// Использование
        mockedList.add("one");
        mockedList.clear();
    }
}