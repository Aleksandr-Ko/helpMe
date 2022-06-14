package util.regex.matcher;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MatcherReplaceExample_2 {

    public static void main(String[] args) {

        String text    =
                "John writes about this, and John Doe writes about that," +
                        " and John Wayne writes about everything."
                ;

        String patternString1 = "((John)(.+?)) ";

        Pattern      pattern      = Pattern.compile(patternString1);
        Matcher      matcher      = pattern.matcher(text);
        StringBuffer stringBuffer = new StringBuffer();

        while(matcher.find()){
            matcher.appendReplacement(stringBuffer, "Joe Blocks ");
            System.out.println(stringBuffer.toString());
        }
        matcher.appendTail(stringBuffer);

        System.out.println(stringBuffer.toString());
    }
}
//Источник: https://java-blog.ru/osnovy/klass-java-matcher
