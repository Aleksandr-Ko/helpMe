package util.regex.my;

import java.util.regex.Pattern;

public class MyTest2 {
    public static void main(String[] args) {

        String text = "197229, город Санкт-Петербург, Лахтинский пр-кт, д. 2 к. 3 стр. 1";

        String patternString = "город";
        Pattern pattern = Pattern.compile(patternString);

        String[] split = pattern.split(text);

        System.out.println("split.length = " + split.length);


        for(String element : split){
            System.out.println("element = " + element);
        }
    }
}
