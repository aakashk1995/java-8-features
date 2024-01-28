package com.example.java8.java8features.corejava;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.time.*;

public class Test {
    public static void main(String[] args) {
        long utcMilliseconds = 1686705023000L;
        ZoneId zoneId = ZoneId.of("Europe/London");

        Instant instant = Instant.ofEpochMilli(utcMilliseconds);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

        System.out.println(localDateTime);
        System.out.println(instant);

        ZonedDateTime zonedDateTime =  instant.atZone(ZoneId.of("Europe/London"));
        System.out.println("ZonedDateTime: " + zonedDateTime);

        System.out.println(zonedDateTime.toOffsetDateTime().toInstant().toEpochMilli());

    }
}
