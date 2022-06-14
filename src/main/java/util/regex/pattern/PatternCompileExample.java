package util.regex.pattern;

import java.util.regex.Pattern;

public class PatternCompileExample {

    public static void main(String[] args) {

        String text    =
                "This is the text to be searched " +
                        "for occurrences of the http:// pattern.";

        String patternString = ".*http://.*";

        Pattern pattern1 = Pattern.compile(patternString);
        Pattern pattern2 = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
    }
}
//Источник: https://java-blog.ru/osnovy/klass-java-pattern
