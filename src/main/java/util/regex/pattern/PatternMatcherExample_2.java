package util.regex.pattern;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PatternMatcherExample_2 {

    public static void main(String[] args) {

        String text    =
                "This is the text to be searched " +
                        "for occurrences of the http:// pattern.";

        String patternString = ".*http://.*";

        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(text);

        boolean matches = matcher.matches();

        System.out.println("matches = " + matches);
    }
}
//Источник: https://java-blog.ru/osnovy/klass-java-pattern
