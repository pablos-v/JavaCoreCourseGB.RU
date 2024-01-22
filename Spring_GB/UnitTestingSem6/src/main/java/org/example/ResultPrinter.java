package org.example;

public class ResultPrinter {

    public static void print(int n) {
        System.out.println(countResult(n));
    }

    private static String countResult(int n) {
        if (n == 0) return "Средние значения равны";
        else if (n > 0) return "Первый список имеет большее среднее значение";
        else return "Второй список имеет большее среднее значение";
    }
}
