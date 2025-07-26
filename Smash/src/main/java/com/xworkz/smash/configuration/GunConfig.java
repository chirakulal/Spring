package com.xworkz.smash.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@ComponentScan("com.xworkz.smash.handler")
public class GunConfig {

    public GunConfig(){
        System.out.println("Running gunconfig created...");
    }

    @Bean
    public StringBuilder builder(){
        System.out.println("-----------------------------------------------------------");
        System.out.println("Running bean method builder");
        return new StringBuilder("Builder");
    }
    @Bean
    public StringBuffer buffer(){
        System.out.println("Running bean method buffer");
        return new StringBuffer("Buffer");
    }
    @Bean
    public Optional<String> optional(){
        System.out.println("Running bean method optional");
        return Optional.of("Present");
    }
    @Bean
    public Thread thread(){
        System.out.println("Running bean method thread");
        return new Thread();
    }
    @Bean
    public AtomicInteger counter(){
        System.out.println("Running bean method counter");
        return new AtomicInteger();
    }
    @Bean
    public Enum<?> enumBean(){
        System.out.println("Running bean method enumBean");
        return Thread.State.NEW;
    }
    @Bean
    public Locale locale(){
        System.out.println("Running bean method locale");
        return Locale.US;
    }
    @Bean
    public Currency currency(){
        System.out.println("Running bean method currency");
        return Currency.getInstance("USD");
    }
    @Bean
    public UUID uuid(){
        System.out.println("Running bean method uuid");
        return UUID.randomUUID();
    }
    @Bean
    public Timer timer(){
        System.out.println("Running bean method timer");
        return new Timer();
    }
}
