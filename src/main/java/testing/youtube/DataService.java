package testing.youtube;

import java.util.List;

public class DataService {


    private DataService() {
    }

    /**
     * Находит максимальное число из списка
     *
     * @param number Список чисел
     * @return максимальное число
     */
    public static int findMax(List<Integer> number) throws NullPointerException {

        if(number == null || number.isEmpty()){
            throw new NullPointerException("null");
        }

        int max = number.get(0);

        for (int i = 0; i < number.size(); i++) {

            if (max < number.get(i)) {
                max = number.get(i);
            }
        }

        return max;
    }

}
