package org.example;

import java.util.List;

/**
 * Задание 1. Создайте программу на Python или Java, которая принимает два списка чисел и выполняет следующие действия:
 * a. Рассчитывает среднее значение каждого списка.
 * b. Сравнивает эти средние значения и выводит соответствующее сообщение:
 * - ""Первый список имеет большее среднее значение"", если среднее значение первого списка больше.
 * - ""Второй список имеет большее среднее значение"", если среднее значение второго списка больше.
 * - ""Средние значения равны"", если средние значения списков равны.
 */
public class App {
    public static void main(String[] args) {
        ListGenerator generator = new ListGenerator();
        List<Integer> listOne = generator.generateRandomList(7);
        List<Integer> listTwo = generator.generateRandomList(10);

        int result = AverageCounter.findAverage(listOne) - AverageCounter.findAverage(listTwo);

        ResultPrinter.print(result);
    }
}
