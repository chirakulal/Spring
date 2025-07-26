package com.xworkz.smash.configuration;

import org.springframework.context.annotation.Bean;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Locale;

public class SmashConfig5 {

    public SmashConfig5(){
        System.out.println(" SmashConfig5 created..........");
    }

    @Bean
    public ThreadGroup threadGroup(){
        System.out.println("-----------------------------------------------------------");
        System.out.println("Running bean method threadGroup");
        return Thread.currentThread().getThreadGroup();
    }
    @Bean
    public StackTraceElement[] stackTraceElements(){
        System.out.println("Running bean method stackTraceElements");
        return Thread.currentThread().getStackTrace();
    }
    @Bean
    public Package aPackage(){
        System.out.println("Running bean method aPackage");
        return this.getClass().getPackage();
    }
    @Bean
    public Year year(){
        System.out.println("Running bean method year");
        return Year.now();
    }
    @Bean
    public Month month(){
        System.out.println("Running bean method month");
        return LocalDate.now().getMonth();
    }
    @Bean
    public DayOfWeek dayOfWeek(){
        System.out.println("Running bean method dayOfWeek");
        return LocalDate.now().getDayOfWeek();
    }
    @Bean
    public Locale[] locales(){
        System.out.println("Running bean method locales");
        return Locale.getAvailableLocales();
    }
    @Bean
    public OperatingSystemMXBean operatingSystemMXBean(){
        System.out.println("Running bean method operatingSystemMXBean");
        return ManagementFactory.getOperatingSystemMXBean();
    }

    @Bean
    public CharsetEncoder charsetEncoder(){
        System.out.println("Running bean method charsetEncoder");
        return StandardCharsets.UTF_8.newEncoder();
    }
    @Bean
    public CharsetDecoder charsetDecoder(){
        System.out.println("Running bean method charsetDecoder");
        return StandardCharsets.UTF_8.newDecoder();
    }
}
