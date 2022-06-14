package util.generic.light;

import java.util.ArrayList;
import java.util.List;

public class Small {
    private static class T {
        public String str;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
//        first(list);  //    first(list) вызовет ошибку, потому что созданный список - это List<Integer>, а не List<T>.
        second(list);   //    second(list) же отработает без ошибок.
    }

    private static void first(List<T> list) { }


    private static <T> void second(List<T> list) { }
//                 /\
    // этот метод  ||   принимает любой <Тип>(Объект)






}
