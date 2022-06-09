package util.stream.metanit.add;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


//https://metanit.com/java/tutorial/10.2.php

public class Add {
    public static void main(String[] args) {
        one();
        createNum();
        createOther();
    }

    static void one() {
        ArrayList<String> cities = new ArrayList<String>();
        Collections.addAll(cities, "Париж", "Лондон", "Мадрид");
        cities.stream() // получаем поток
                .filter(s -> s.length() == 6) // применяем фильтрацию по длине строки
                .forEach(s -> System.out.println(s)); // выводим отфильтрованные строки на консоль
    }

    static void createNum() {
        IntStream intStream = Arrays.stream(new int[]{1, 2, 4, 5, 7});
        intStream.forEach(i -> System.out.println(i));

        LongStream longStream = Arrays.stream(new long[]{100, 250, 400, 5843787, 237});
        longStream.forEach(l -> System.out.println(l));

        DoubleStream doubleStream = Arrays.stream(new double[]{3.4, 6.7, 9.5, 8.2345, 121});
        doubleStream.forEach(d -> System.out.println(d));
    }

    static void createOther() {


        IntStream intStream = IntStream.of(1, 2, 4, 5, 7);
        intStream.forEach(i -> System.out.println(i));

        LongStream longStream = LongStream.of(100, 250, 400, 5843787, 237);
        longStream.forEach(l -> System.out.println(l));

        DoubleStream doubleStream = DoubleStream.of(3.4, 6.7, 9.5, 8.2345, 121);
        doubleStream.forEach(d -> System.out.println(d));


        Stream<String> citiesStream = Stream.of("Париж", "Лондон", "Мадрид");
        citiesStream.forEach(s -> System.out.println(s));
// можно передать массив
        String[] cities = {"Париж", "Лондон", "Мадрид"};
        Stream<String> citiesStream2 = Stream.of(cities);
    }
}
