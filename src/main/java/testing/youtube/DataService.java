package testing.youtube;

import java.util.Comparator;
import java.util.List;

public class DataService {

    private DataService() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Находит максимальное число из списка
     *
     * @param numbers Список чисел
     * @return максимальное число
     */
    public static int findMax(List<Integer> numbers) throws NullPointerException {

        if (numbers == null || numbers.isEmpty()) {
            throw new NullPointerException("null");
        }

        int max = numbers.get(0);

        for (Integer number : numbers) {

            if (max < number) {
                max = number;
            }
        }

        return max;
    }

    public static int findMaxByStream(List<Integer> numbers) {
        return numbers.stream().max(Comparator.naturalOrder()).orElseThrow(() -> new NullPointerException("List of numbers is empty"));
    }
}
