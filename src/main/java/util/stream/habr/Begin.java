package util.stream.habr;

import java.util.Arrays;
import java.util.Collection;

public class Begin {

   static Collection<Integer> collection = Arrays.asList(1, 2, 3, 4, 5);



    public static void main(String[] args) {

        // Stream Api позволяет писать обработку структур данных в стиле SQL,
        // то если раньше задача получить сумму всех нечетных чисел из коллекции решалась следующим кодом:
        Integer sumOddOld = 0;
        for (Integer i : collection) {
            if (i % 2 != 0) {
                sumOddOld += i;
            }
        }
        System.out.println(sumOddOld);


        // То с помощью Stream Api можно решить такую задачу в функциональном стиле:
        Integer sumOdd = collection.stream().filter(o -> o % 2 != 0).reduce((s1, s2) -> s1 + s2).orElse(0);
        System.out.println(sumOdd);


        // Более того, Stream Api позволяет решать задачу параллельно лишь изменив
        // stream() на parallelStream() без всякого лишнего кода, т.е.
        Integer sumOddP = collection.parallelStream().filter(o -> o % 2 != 0).reduce((s1, s2) -> s1 + s2).orElse(0);
        System.out.println(sumOddP);



    }
}
