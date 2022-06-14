package util.function.lamda;

import java.util.Scanner;
import java.util.function.*;

public class LambdaApp {

    public static void main(String[] args) {

//        viewPredicate();
//        viewBinaryOperator();
//        viewUnaryOperator();
//        viewFunction();
//        viewConsumer();
        viewSupplier();
    }

    static void viewPredicate(){

        Predicate<Integer> isPositive = x -> x > 0;

        System.out.println(isPositive.test(5)); // true
        System.out.println(isPositive.test(-7)); // false
    }

    static void viewBinaryOperator(){

        BinaryOperator<Integer> multiply = (x, y) -> x*y;

        System.out.println(multiply.apply(3, 5)); // 15
        System.out.println(multiply.apply(10, -2)); // -20
    }

    static void viewUnaryOperator(){

        UnaryOperator<Integer> square = x -> x*x;

        System.out.println(square.apply(5)); // 25
    }

    /**
     * принимает один аргумент и конвертирует
     */
    static void viewFunction(){

        Function<Integer, String> convert = x-> String.valueOf(x) + " долларов";

        System.out.println(convert.apply(5)); // 5 долларов
    }

    /**
     * подставляет данные
     */
    static void viewConsumer(){

        Consumer<Integer> printer = x-> System.out.printf("%d долларов \n", x); // подставляет вместо %d

        printer.accept(600); // 600 долларов
    }


    static void viewSupplier(){
    Supplier<User> userFactory = ()->{

        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        return new User(name);
    };


    User user1 = userFactory.get();
    User user2 = userFactory.get();

        System.out.println("Имя user1: " + user1.getName());
        System.out.println("Имя user2: " + user2.getName());
}
}
class User{

    private String name;
    String getName(){
        return name;
    }
    User(String n){
        this.name=n;
    }

}
