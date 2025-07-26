package com.xworkz.smash.configuration;

import org.springframework.context.annotation.Bean;

import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

public class BikeConfig {

    public BikeConfig(){
        System.out.println(" BikeConfig created..........");
    }

    @Bean
    public ConcurrentSkipListSet<String> concurrentSkipListSet(){
        System.out.println("-----------------------------------------------------------");
        System.out.println("Running bean method concurrentSkipListSet");
        return new ConcurrentSkipListSet<>();
    }
    @Bean
    public IdentityHashMap<String,String > identityHashMap(){
        System.out.println("Running bean method identityHashMap");
        return new IdentityHashMap<>();
    }
    @Bean
    public WeakHashMap<Objects,Objects> weakHashMap(){
        System.out.println("Running bean method weakHashMap");
        return new WeakHashMap<>();
    }
    @Bean
    public Spliterator<String> spliterator(){
        System.out.println("Running bean method spliterator");
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        return list.spliterator();
    }
    @Bean
    public Stream<String> stream(){
        System.out.println("Running bean method stream");
        return Stream.of("X","Y");
    }
    @Bean
    public IntSummaryStatistics statistics(){
        System.out.println("Running bean method statistics");
        return new IntSummaryStatistics();
    }
    @Bean
    public Scanner scanner(){
        System.out.println("Running bean method scanner");
        return new Scanner(System.in);
    }
    @Bean
    public Random random(){
        System.out.println("Running bean method random");
        return new Random();
    }
    @Bean
    public SecureRandom secureRandom(){
        System.out.println("Running bean method secureRandom");
        return new SecureRandom();
    }
    @Bean
    public Base64.Encoder encoder(){
        System.out.println("Running bean method encoder");
        return Base64.getEncoder();
    }
}
