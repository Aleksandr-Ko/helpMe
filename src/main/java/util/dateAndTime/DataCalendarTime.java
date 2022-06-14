package util.dateAndTime;

import java.util.Calendar;
import java.util.Date;

//https://metanit.com/java/tutorial/12.3.php
//https://stackoverflow.com/questions/17210839/get-last-week-date-range-for-a-date-in-java

public class DataCalendarTime {
    public static void main(String[] args) {

/*
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.set(Calendar.DATE, 1);
        calendarStart.add(Calendar.MONTH, -1);
        Date fromPeriod = calendarStart.getTime();

        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.add(Calendar.MONTH, -1);
        calendarEnd.set(Calendar.DATE, calendarEnd.getActualMaximum(Calendar.DATE));
        Date toPeriod = calendarEnd.getTime();

        // Начало года
        calendarStart.set(Calendar.MONTH, 0);
        Date fromYear = calendarStart.getTime();

        // Конец прошлого года
        Calendar calendarPrev = Calendar.getInstance();
        calendarPrev.add(Calendar.YEAR, -1);
        calendarPrev.set(Calendar.DATE, 1);
        calendarPrev.set(Calendar.MONTH, 11);
        calendarPrev.set(Calendar.DATE, calendarPrev.getActualMaximum(Calendar.DATE));
        Date to = calendarPrev.getTime();

        // Начало прошлого года
        Calendar calendarPrevStart = Calendar.getInstance();
        calendarPrevStart.add(Calendar.YEAR, -1);
        calendarPrevStart.set(Calendar.DATE, 1);
        calendarPrevStart.set(Calendar.MONTH, 0);
        Date from = calendarPrevStart.getTime();

        // Текущая дата
        Date now = new Date();

        System.out.println(fromPeriod + " начальная дата запроса" + " (fromPeriod)");
        System.out.println(toPeriod + " конечная дата запроса" + " (toPeriod)\n");

        System.out.println(fromYear + " прошлый год перед запросом" +" (fromYear)\n");
        System.out.println(to + " конец периода прошлого года" + " (to)");
        System.out.println(from + " начало периода прошлого года" + " (from)\n");
        System.out.println(now + " сегодня" + " (now)");
*/

//        final ZonedDateTime input = ZonedDateTime.now();
//        System.out.println(input);
//
//        final ZonedDateTime startOfLastWeek = input.minusWeeks(1).with(DayOfWeek.MONDAY);
//        System.out.println(startOfLastWeek);
//
//        final ZonedDateTime endOfLastWeek = startOfLastWeek.plusDays(6);
//        System.out.println(endOfLastWeek);


        Date date = new Date();


        // создаем дату запроса
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -1);

        // вычисляем понедельник прошлой недели от даты запроса
        int i = calendar.get(Calendar.DAY_OF_WEEK) - calendar.getFirstDayOfWeek();
        calendar.add(Calendar.DATE, -i - 7);
        Date startLastWeek = calendar.getTime();

        // вычисляем воскресенье прошлой недели от даты запроса
        calendar.add(Calendar.DATE, 6);
        Date endLastWeek = calendar.getTime();

        // вычисляем понедельник выбранной недели
        calendar.add(Calendar.DATE, 1);
        Date startThisWeek = calendar.getTime();

        // вычисляем воскресенье выбранной недели
        calendar.add(Calendar.DATE, 6);
        Date endThisWeek = calendar.getTime();

        System.out.println(startLastWeek + " Понедельник прошлой недели от даты запроса");
        System.out.println(endLastWeek + " Воскресенье прошлой недели от даты запроса");
        System.out.println(startThisWeek + " Понедельник от даты запроса");
        System.out.println(endThisWeek + " Воскресенье от даты запроса");

    }

}
