package com.experiments.internal.all;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.boot.autoconfigure.cache.CacheProperties;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class InstantTest {
    public static void main(String[] args) {

        Instant i30 = Instant.now().minus(30, ChronoUnit.MINUTES);
        Instant i40 = Instant.now().minus(40, ChronoUnit.MINUTES);
        Instant i50 = Instant.now().minus(50, ChronoUnit.MINUTES);
        Instant i60 = Instant.now().minus(60, ChronoUnit.MINUTES);

        System.out.println(Instant.now().getEpochSecond());
        System.out.println(Instant.now().minus(30, ChronoUnit.MINUTES).isBefore(Instant.now()));

        TreeMap<Instant, Integer> map = new TreeMap();
        map.put(i30, 30);
        map.put(i40, 40);
        map.put(i50, 50);
        map.put(i60, 60);

        Instant i30_v2 = Instant.now().minus(29, ChronoUnit.MINUTES);
        Instant i41 = Instant.now().minus(41, ChronoUnit.MINUTES);

        System.out.println(map.subMap(i41, i30_v2));

        String out = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").
                withZone(ZoneId.systemDefault()).format(Instant.now());
        System.out.println(out);

        Caffeine.newBuilder().ticker()

    }
}
