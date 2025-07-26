package com.xworkz.smash.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

@Configuration
public class BulletConfig {

    public BulletConfig(){
        System.out.println(" BulletConfig created..........");
    }

    @Bean
    public Hashtable<String,String> hashtable(){
        System.out.println("-----------------------------------------------------------");
        System.out.println("Running bean method hashtable");
        return new Hashtable<>();
    }
    @Bean

    public PriorityQueue<String> priorityQueue(){
        System.out.println("Running bean method priorityQueue");
        return new PriorityQueue<>();
    }
    @Bean

    public EnumSet<Thread.State> enumSet(){
        System.out.println("Running bean method enumSet");
        return EnumSet.allOf(Thread.State.class);
    }
    @Bean
    public EnumMap<Thread.State,String> enumMap(){
        System.out.println("Running bean method enumMap");
        return new EnumMap<>(Thread.State.class);
    }
    @Bean
    public HashSet<String> hashSet(){
        System.out.println("Running bean method hashSet");
        return new HashSet<>();
    }
    @Bean

    public HashMap<String,Double> hashMap(){
        System.out.println("Running bean method hashMap");
        return new HashMap<>();
    }
    @Bean
    public ArrayList<String> arrayList(){
        System.out.println("Running bean method arrayList");
        return new ArrayList<>();
    }
    @Bean
    public LinkedList<Double> list(){
        System.out.println("Running bean method list");
        return new LinkedList<>();
    }
    @Bean
    public ConcurrentHashMap<String,String> concurrentHashMap(){
        System.out.println("Running bean method concurrentHashMap");
        return new ConcurrentHashMap<>();
    }
    @Bean
    public ConcurrentSkipListMap<Integer,String > skipListMap(){
        System.out.println("Running bean method skipListMap");
        return new ConcurrentSkipListMap<>();
    }
}
