package io.beansprout.Basics;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static io.beansprout.Basics.Repeatables.Author;

@Author(name = "Kollier",
        method = "getDate()",
        date = "01/27/2022",
        modifyReason = "Because I can")
public class DateTime {
    public static void main(String[] args) {
        LocalTime startTime = LocalTime.now();

        getSpecifiedDate(2011, 6, 15); // 2011, Month.JUNE.getValue(), 15
        getDate();
        getTime();
        getDateAndTime();
        getZonedDateTime();
        getTimePeriod();
        getChronoUnit();
        getFormattedDate();

        LocalTime endTime = LocalTime.now();

        System.out.println("It took " + (endTime.getNano() - startTime.getNano()) + " nanoseconds to run");
    }

    public static void getSpecifiedDate(int year, int month, int day) {
        System.out.println(LocalDate.of(year, month, day));
    }

    public static void getDate() {
        System.out.println(LocalDate.now());
    }

    public static void getTime() {
        System.out.println(LocalTime.now());
    }

    public static void getDateAndTime() {
        System.out.println(LocalDateTime.now());
    }

    public static void getZonedDateTime() {
        System.out.println(ZonedDateTime.now());
    }

    public static void getTimePeriod() {
        System.out.println(Period.between(LocalDate.now(), LocalDate.now().plusDays(10)));
    }

    public static void getChronoUnit() {
        System.out.println(ChronoUnit.CENTURIES.getDuration().getSeconds());
    }

    public static void getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate time = LocalDate.now();
        System.out.println(time.format(formatter));
    }
}
