package util.regex.matcher;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CreateMatcherExample_1 {

    public static void main(String[] args) {

        String text    =
                "This is the text to be searched  datePeriod {date} " +
                        "for occurrences of the http:// pattern.";

//        String patternString = ".*http://.*";
        String patternString = ".*datePeriod.*";

        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(text);

        System.out.println("lookingAt = " + matcher.lookingAt());
        System.out.println("matches   = " + matcher.matches());
    }
}
//Источник: https://java-blog.ru/osnovy/klass-java-matcher
