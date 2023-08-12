package stream_training;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6)
//                .collect(Collectors.filtering(
//                        x -> x % 2 == 0,
//                        Collectors.toList()));

        .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        ints.add(3);

        System.out.println(ints);
    }
}
