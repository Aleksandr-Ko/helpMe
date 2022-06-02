package util.regex.matcher;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MatcherReplaceExample_1 {

    public static void main(String[] args) {

        String text    =
                "John writes about this, #and# John #Do_e1# writes about that," +
                        " and John Wayne writes #about# everything.  JohnDate"
                ;

//        String patternString1 = "((John)(.+?))";
        String patternString1 = "#[A-z|0-9]+#";         // найти символ


        Pattern pattern = Pattern.compile(patternString1);
        Matcher matcher = pattern.matcher(text);

        String replaceAll = matcher.replaceAll("ALL");
        System.out.println("replaceAll   = " + replaceAll);

        String replaceFirst = matcher.replaceFirst("FIRST");
        System.out.println("replaceFirst = " + replaceFirst);
    }
}
//Источник: https://java-blog.ru/osnovy/klass-java-matcher
