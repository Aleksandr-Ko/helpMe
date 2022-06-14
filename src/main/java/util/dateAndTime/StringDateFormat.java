package util.dateAndTime;

import java.util.Calendar;

public class StringDateFormat {

    public static void main(String[] args) {

        Calendar c = Calendar.getInstance();

        String s = String.format("\nпример вывода\n %1$te-%1$tm-%1$tY", c);

        System.out.println(s);
    }
}
