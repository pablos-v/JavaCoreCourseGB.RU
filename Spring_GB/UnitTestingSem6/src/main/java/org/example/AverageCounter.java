package org.example;

import java.util.List;

public class AverageCounter {

    private AverageCounter(){

    }

    public static int findAverage(List<Integer> list) {
        return (int) list.stream()
                .mapToInt(a -> a)
                .average().orElse(0);
    }
}
