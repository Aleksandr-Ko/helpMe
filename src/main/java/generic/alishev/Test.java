package generic.alishev;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<? super Animal> list = new ArrayList<>();
        list.add(new Animal("кошачие"));
        list.add(new Dog("Овчарка"));

        System.out.println(list);

    }



}
