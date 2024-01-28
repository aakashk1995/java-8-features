package com.example.java8.java8features.corejava;

import java.time.*;

public class utcToDateTime {
    public static void main(String[] args) {

        long utcMilliseconds = 1686705023000L;
        Instant instant = Instant.ofEpochMilli(utcMilliseconds);
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

//        LocalDate localDate = LocalDate.of(2023, 6, 14);
//        LocalTime localTime = LocalTime.of(1,10,23,000);
//        LocalDateTime localDateTime2 = LocalDateTime.of(localDate,localTime);
        System.out.println(localDateTime2);

        // Time zone to consider
        ZoneId zoneId = ZoneId.of("Europe/London");

        ZonedDateTime zonedDateTime = localDateTime2.atZone(zoneId);



        System.out.println(zonedDateTime.toOffsetDateTime().toInstant().toEpochMilli());

        // Convert UTC milliseconds to Instant
//        Instant instant = Instant.ofEpochMilli(utcMilliseconds);
//
//        // Convert Instant to LocalDateTime as per the provided time zone
//        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(timeZoneId));
//
//        // Output the result
//        System.out.println("UTC Time " + instant);
//        System.out.println("UTC Milliseconds: " + utcMilliseconds);
//        System.out.println("Converted LocalDateTime: " + localDateTime);
//        System.out.println("Converted LocalDateTime to instant millis: " + localDateTime.atZone(ZoneId.of(timeZoneId)).toInstant().toEpochMilli());

    }
}
