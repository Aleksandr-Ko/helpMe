package util.stream.foreach.map;

import java.util.HashMap;
import java.util.Map;

public class MapStream {
    public static void main(String[] args) {
        forEach();
    }
    static  void forEach(){
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("Forrest Gump", 8.8);
        map.put("The Matrix", 8.7);
        map.put("The Hunt", 8.3);
        map.put("Monty Python's Life of Brian", 8.1);
        map.put("Who's Singin' Over There?", 8.9);

        // распечатаем значения каждого фильма, который имеет оценку выше 8.4:
        map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 8.4)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));


        // Здесь мы преобразовали файл Map в Set via entrySet(), передали его в потоковом режиме,
        // отфильтровали на основе оценки и, наконец, распечатали их через файл forEach().
        // Вместо того чтобы основывать это на возврате filter(), мы могли бы построить
        // нашу логику на побочных эффектах и пропустить filter()метод:
        map.entrySet()
                .stream()
                .forEach(entry -> {
                            if (entry.getValue() > 8.4) {
                                System.out.println(entry.getKey() + ": " + entry.getValue());
                            }
                        }
                );


        // Наконец, мы можем опустить оба метода stream()и filter(), начав с forEach()самого начала:
        map.forEach((k, v) -> {
            if (v > 8.4) {
                System.out.println(k + ": " + v);
            }
        });
    }


}
