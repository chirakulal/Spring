package com.xworkz.smash.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Configuration
@ComponentScan("com.xworkz.smash.processor")
public class processConfig {
    public processConfig(){
        System.out.println("Running processConfig created...");
    }
    @Bean
    public Supplier<String> supplier(){
        System.out.println("-----------------------------------------------------------");
        System.out.println("Running bean method supplier");
        return ()->"Supplied Value";
    }

    @Bean
    public Predicate<Integer> isPositive(){
        System.out.println("Running bean method isPositive");
        return i->i>0;
    }

    @Bean
    public Function<String ,Integer> parseInt(){
        System.out.println("Running bean method parseInt");
        return Integer::parseInt;
    }

    @Bean
    public Runnable runnable(){
        System.out.println("Running bean method runnable");
        return ()-> System.out.println("Running...");
    }

    @Bean
    public Comparator<Integer> comparator(){
        System.out.println("Running bean method comparator");
        return Integer::compare;
    }

    @Bean
    public CharSequence charSequence(){
        System.out.println("Running bean method charSequence");
        return "Sequence";
    }

    @Bean
    public Iterable<String> iterable(){
        System.out.println("Running bean method iterable");
        return new ArrayList<>(Arrays.asList("a","b","c"));
    }

    @Bean
    public Collection<String> collection(){
        System.out.println("Running bean method collection");
        return new LinkedList<>(Arrays.asList("X","Y","Z"));
    }

    @Bean
    public Deque<String> deque(){
        System.out.println("Running bean method deque");
        return new ArrayDeque<>();
    }

    @Bean
    public Calendar calendar(){
        System.out.println("Running bean method calendar");
        return Calendar.getInstance();
    }
}
