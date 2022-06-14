package util.stream.metanit.filter;

import java.util.stream.Stream;

public class Filter {
    public static void main(String[] args) {

//        bust();
//        filter();
//        filterNew();
//        display();
//        flatMap();

    }

    /**
     * Перебор элементов. Метод forEach
     */
    static void bust() {
        Stream<String> citiesStream = Stream.of("Париж", "Лондон", "Мадрид", "Берлин", "Брюссель");

        citiesStream.forEach(s -> System.out.println(s));
        // равнозначные записи
        citiesStream.forEach(System.out::println);
    }

    /**
     * Фильтрация. Метод filter
     */
    static void filter() {
        Stream<String> citiesStream = Stream.of("Париж", "Лондон", "Мадрид", "Берлин", "Брюссель");
        citiesStream.filter(s -> s.length() == 6)
                .forEach(s -> System.out.println(s));
    }

    /**
     * Фильтрация. Метод filter по цене
     */
    static void filterNew() {
        Stream<Phone> phoneStream = Stream.of(
                new Phone("iPhone 6 S", 54000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000));

        phoneStream.filter(p -> p.getPrice() < 50000)
                .forEach(p -> System.out.println(p.getName()));
    }

    /**
     * Отображение. Метод map
     */
    static void display() {
        // Отображение или маппинг позволяет задать функцию преобразования одного объекта в другой,
        // то есть получить из элемента одного типа элемент другого типа. Для отображения используется
        // метод map, который имеет следующее определение:
        // <R> Stream<R> map(Function<? super T, ? extends R> mapper)

        Stream<Phone> phoneStream = Stream.of(
                new Phone("iPhone 6 S", 54000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000));
/*
        phoneStream
                .map(p -> p.getName()) // помещаем в поток только названия телефонов
                .forEach(s -> System.out.println(s));
*/
        phoneStream
                .map(p -> "название: " + p.getName() + " цена: " + p.getPrice())
                .forEach(s -> System.out.println(s));
    }

    /**
     * Плоское отображение. Метод flatMap
     */
    static void flatMap() {
        // Например, в примере выше мы выводим название телефона и его цену. Но что, если мы хотим
        // установить для каждого телефона цену со скидкой и цену без скидки. То есть из одного
        // объекта Phone нам надо получить два объекта с информацией, например, в виде строки.
        // Для этого применим flatMap:

        Stream<Phone> phoneStream = Stream.of(
                new Phone("iPhone 6 S", 54000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000));

        phoneStream
                .flatMap(p -> Stream.of(
                        String.format("название: %s  цена без скидки: %d", p.getName(), p.getPrice()),
                        String.format("название: %s  цена со скидкой: %d", p.getName(), p.getPrice() - (int) (p.getPrice() * 0.1))
                ))
                .forEach(s -> System.out.println(s));

    }
}
