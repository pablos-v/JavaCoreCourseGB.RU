package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListGenerator {
    private final Random random = new Random();

    public List<Integer> generateRandomList(int length) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            ls.add(random.nextInt(10));
        }
        return ls;
    }

}
