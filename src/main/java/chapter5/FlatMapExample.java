package chapter5;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {
    public static void practice2(){
        List<Integer> integers1 = List.of(1, 2, 3, 4);
        List<Integer> integers2 = List.of(3, 4);

        integers1.stream()
                .flatMap(i1 -> integers2.stream()
                        .map(i2 -> new int[]{i1, i2})
                )
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
}
