package interfaceFunc;

import java.util.function.Predicate;

public class Functional {
    public static void main(String[] args) {
        
        

        Predicate<String> predicate = (s) -> s.length() > 0;
/*
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
*/

        System.out.println(predicate.test("foo"));                 // true
        System.out.println(predicate.negate().test("foo"));        // false

    }
}
