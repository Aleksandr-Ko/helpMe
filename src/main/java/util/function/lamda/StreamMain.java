package util.function.lamda;

import java.util.ArrayList;
import java.util.List;

public class StreamMain {

    // объявление списка
    static List<String> places = new ArrayList<>();

    // заполнение данными
    public static List<String> getPlaces(){

        // добавление страны и города
        places.add("Nepal, Kathmandu");
        places.add("Nepal, Pokhara");
        places.add("India, Delhi");
        places.add("USA, New York");
        places.add("Africa, Nigeria");

        return places;
    }

    public static void main( String[] args ) {

        List<String> myPlaces = getPlaces();

        System.out.println("Places from Nepal:");

        // Фильтрация городов
        myPlaces.stream()
                .filter((p) -> p.startsWith("Nepal"))
                .map((p) -> p.toUpperCase())
                .sorted()
                .forEach((p) -> System.out.println(p));

    }

}
