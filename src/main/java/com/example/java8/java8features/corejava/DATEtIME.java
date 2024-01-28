package com.example.java8.java8features.corejava;

import java.time.*;
import java.util.Date;
import java.util.Objects;

public class DATEtIME {
    public static void main(String[] args) {
        Date date = new Date(1686706230000L);
        System.out.println(date);
        System.out.println(date.getTime());
        getZonedInstant2(1686706230000L,"Europe/London");
    }

    public static  Instant getZonedInstant(Long value, String timezone){
        if (Objects.nonNull(value)) {
            Instant instant = Instant.ofEpochMilli(value);
          //  System.out.println("UTC TIME " + instant);
              ZoneId zoneId = ZoneId.of(timezone);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
           System.out.println(localDateTime);
          //  ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
          //  return zonedDateTime.toOffsetDateTime().toInstant();
        }
        return null;
    }
    // Long Value is in UTC
    // TimeZone
    public static Instant getZonedInstant2(Long value , String timezone){
        if (Objects.nonNull(value)) {
            LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneOffset.UTC);
            ZoneId zoneId = ZoneId.of(timezone);
            ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
            Instant zonedInstant = zonedDateTime.toInstant();
            System.out.println("Zoned Date Time without UTC and with TimeZone " + zonedDateTime);
            System.out.println("ZONED date time in UTC " + zonedInstant);
            System.out.println("zoned date time in milli " + zonedInstant.toEpochMilli());
        }
        return null;
    }
}
