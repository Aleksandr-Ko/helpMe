package util.stream.foreach.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ListStream {
    public static void main(String[] args) {
//        forEach();
        returnNumberLong();
    }

    static void forEach() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

//        for (Integer element : list) {System.out.print(element + " ");}

//        list.stream().forEach((k) -> {System.out.print(k + " ");});

//        list.stream().forEach(System.out::println);

        list.forEach(System.out::println);
    }

    static void returnNumberLong() {

        List<Integer> targetList = Arrays.asList(1, -2, 3, -4, 5, 6, -7);

        long result1 = targetList
                .stream()
                .filter(integer -> integer > 0)
                .count();
        System.out.println("Result: " + result1);


        // второй вариант
        AtomicInteger result2 = new AtomicInteger();

        targetList.stream()
                .forEach(integer -> {
                    if (integer > 0)
                        result2.addAndGet(1);
                });
        System.out.println("Result: " + result2);
    }


}
