package org.example;

import com.google.common.collect.Maps;

import java.util.*;

/**
 * В качестве задачи предлагаю вам реализовать код для
 * демонстрации парадокса Монти Холла (Парадокс Монти Холла
 * — Википедия ) и наглядно убедиться в верности парадокса
 * (запустить игру в цикле на 1000 и вывести итоговый счет).
 * Необходимо:
 * ●  * Создать свой Java Maven или Gradle проект;
 * ●  * Самостоятельно реализовать прикладную задачу;
 * ●  * Сохранить результат в HashMap<шаг теста, результат>
 * ●  * Вывести на экран статистику по победам и поражениям
 */
public class Main {
    public static void main(String[] args) {

        int ITERATIONS = 1000;

        Map<Integer, Integer> resIfChange = counter(ITERATIONS, true);

        Map<Integer, Integer> resIfNotChange = counter(ITERATIONS, false);

        System.out.println("Rolls: " + ITERATIONS + "\nwins if change: "
                + Maps.filterValues(resIfChange, integer -> Objects.equals(integer, 1)).values().size()
                + "\nwins if not change: " + Maps.filterValues(resIfNotChange, integer -> Objects.equals(integer, 1)).values().size());
    }

    private static Map<Integer, Integer> counter(int ITERATIONS, boolean toChange) {
        Map<Integer, Integer> res = new HashMap<>();
        Random r = new Random();

        for (int i = 0; i < ITERATIONS; i++) {
            int car = r.nextInt(3);// place car
            int choice = r.nextInt(3);// player choose
            int openGoat = randomOfLeavingNumbers(car, choice, r);// open 1 goat
            if (toChange) choice = randomOfLeavingNumbers(choice, openGoat, r);
            res.put(i + 1, car == choice ? 1 : 0);
        }
        return res;

    }

    private static int randomOfLeavingNumbers(int first, int second, Random r) {
        List<Integer> ls = new ArrayList<>(List.of(0, 1, 2));
        if (first != second) {
            ls.removeAll(List.of(first, second)); // останется 1 число
            return ls.get(0); // венём одно оставшееся
        }
        ls.remove(first); // останется 2 числа
        return ls.get(r.nextInt(2)); // вернём случайное из двух
    }
}