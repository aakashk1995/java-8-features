package com.example.java8.java8features.corejava;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateTimeTest {

    public static void main(String[] args) {
        Date date = new Date();

        // Convert to instant with a specific timezone
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneId);
        ZoneId currentZoneId = zonedDateTime.getZone();
        System.out.println("Current Timezone: " + currentZoneId);
     //   ZoneId zoneId = ZoneId.of("Europe/London");
     //   LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
    //    Instant convertedInstant = localDateTime.toInstant(zoneId.getRules().getOffset(localDateTime));

        // Output the converted instant
      //  System.out.println("Converted Instant: " + convertedInstant.toEpochMilli());

        System.out.println("Converted Instant: " + instant);
    }
}
