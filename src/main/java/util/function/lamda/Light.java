package util.function.lamda;

public class Light {

    // функциональный интерфейс
    @FunctionalInterface
    interface MyInterface {
        // абстрактный метод
        double getPiValue();
    }


//    public static void main(String[] args) {
//
//        // объявление ссылки на MyInterface
//        MyInterface ref;
//
//        // лямбда-выражение
//        ref = () -> 3.1415;
//
//        System.out.println("Value of Pi = " + ref.getPiValue());
//    }


    @FunctionalInterface
    interface MyInterfaceTwo {
        // абстрактный метод
        String reverse(String n);
    }

    public static void two() {

        // объявление ссылки на MyInterface
        // присвоение лямбда-выражения ссылке
        MyInterfaceTwo ref = (str) -> {
            String result = "";
            for (int i = str.length()-1; i >= 0 ; i--)
                result += str.charAt(i);
            return result;
        };
        // вызов метода из интерфейса
        System.out.println("Lambda reversed = " + ref.reverse("Lambda"));
    }

}
