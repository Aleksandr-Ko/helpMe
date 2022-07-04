package util.stream.foreach;

import java.util.Arrays;
import java.util.List;

public class FilterExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Orange");

        one(fruits);
        two(fruits);

    }

    static void one(List<String> fruits) {

        // Традиционный подход
        for (String fruit : fruits) {
            if (!fruit.equals("Orange")) {
                System.out.println(fruit + " ");
            }
        }

        // Потоковый подход
        fruits.stream()
                .filter(fruit -> !fruit.equals("Orange"))
                .forEach(fruit -> System.out.println(fruit));

    }

    static void two(List<String> fruits) {

        fruits.stream()
                .filter(FilterExample::isNotOrange)
                .forEach(System.out::println);
    }

    private static boolean isNotOrange(String fruit) {
        return !fruit.equals("Orange");
    }
}
