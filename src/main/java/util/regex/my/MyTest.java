package util.regex.my;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTest {
    public static void main(String[] args) {

        String result = "";

        String text = "197229, г. Санкт-Петербург, Лахтинский пр-кт, д. 2 к. 3 стр. 1";

        String patternString1 = "((г.)(.+?)) ";
        String patternString2 = "((город )(.+?)) ";

        Pattern pattern      = Pattern.compile(patternString1);
        Matcher matcher      = pattern.matcher(text);

        StringBuffer stringBuffer = new StringBuffer();

        while(matcher.find()){
            result = matcher.group();
        }

        System.out.println(result);

    }


}
