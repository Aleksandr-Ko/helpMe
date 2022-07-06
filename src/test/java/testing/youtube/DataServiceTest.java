package testing.youtube;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DataServiceTest {

    @Test
    public void testFindMax() {

        // создаем заготовки, чтоб отправить на тестирования
        List<Integer> num1 = Arrays.asList(1,2,3,4,5);
        List<Integer> num2 = Arrays.asList(65,5,48,28,47);

        // обращаемся к методу который хотим тестировать
        int max1 = DataService.findMax(num1);
        int max2 = DataService.findMax(num2);

        // создаем утверждение о том что полученное и есть то что нам нужно
        assertThat(max1).isEqualTo(5);
        assertThat(max2).isEqualTo(65);
    }

    // проверка на получение NullPointerException
    @Test(expected = NullPointerException.class)
    public void testFindMaxException() {
        List<Integer> num1 = Collections.emptyList();        // size = 0
        List<Integer> num2 = null;                           // null

        DataService.findMax(num1);
        DataService.findMax(num2);
    }


    @Test
    public void testFindMaxStream() {

        // создаем заготовки, чтоб отправить на тестирования
        List<Integer> num1 = Arrays.asList(1,2,3,4,5);
        List<Integer> num2 = Arrays.asList(65,5,48,28,47);

        // обращаемся к методу который хотим тестировать
        int max1 = DataService.findMaxByStream(num1);
        int max2 = DataService.findMaxByStream(num2);

        // создаем утверждение о том что полученное и есть то что нам нужно
        assertThat(max1).isEqualTo(5);
        assertThat(max2).isEqualTo(65);
    }

    // проверка на получение NullPointerException and isEmpty_List

    @Test(expected = NullPointerException.class)
    public void testFindMaxExceptionStream() {
        List<Integer> num1 = Collections.emptyList();       // size = 0
        List<Integer> num2 = null;                          // null

        DataService.findMaxByStream(num1);
        DataService.findMaxByStream(num2);
    }
}