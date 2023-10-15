package com.example.mymethodistapplication;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalTime;

public class CalendarUtils {
    public static LocalDate selectedDate;
    public static String formattedDate(LocalDate date) {
        DateTimeFormatter formatter = null;
        formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return date.format(formatter);
    }

    public static String formattedTime(LocalTime time) {
        DateTimeFormatter formatter = null;
        formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        return time.format(formatter);
    }
    public static String monthYearFromDate(LocalDate date){

        DateTimeFormatter formatter = null;
        formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);
    }
    public static ArrayList<LocalDate> daysInMonthArray(LocalDate date)
    {
        ArrayList<LocalDate> daysInMonthArray = new ArrayList<>();
        YearMonth yearMonth = null;
        yearMonth = YearMonth.from(date);
        int daysInMonth = 0;
        daysInMonth = yearMonth.lengthOfMonth();
        LocalDate firstOfMonth = null;
        firstOfMonth = CalendarUtils.selectedDate.withDayOfMonth(1);
        int dayOfWeek = 0;
        dayOfWeek = firstOfMonth.getDayOfWeek().getValue();
        for (int i = 1; i<=42; i++)
        {
            if (i <=dayOfWeek || i > daysInMonth + dayOfWeek){
                daysInMonthArray.add(null);
            }
            else
            {
                daysInMonthArray.add(LocalDate.of(selectedDate.getYear(),selectedDate.getMonth(),i -dayOfWeek));

            }
        }
        return daysInMonthArray;
    }
    public static ArrayList<LocalDate> daysInWeekArray(LocalDate selectedDate) {
        ArrayList<LocalDate> days = new ArrayList<>();
        LocalDate current = sundayForDate(selectedDate);
        LocalDate endDate = current.plusWeeks(1);

        while (current.isBefore(endDate))
        {
            days.add(current);
            current = current.plusDays(1);
        }
        

        return days;
    }

    private static LocalDate sundayForDate(LocalDate current) {
        LocalDate onWeekAgo = current.minusWeeks(1);

        while(current.isAfter(onWeekAgo)){
            if(current.getDayOfWeek()== DayOfWeek.SUNDAY)
                return current;

            current = current.minusDays(1);

        }
        return null;
    }



}
