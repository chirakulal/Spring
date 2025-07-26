package com.xworkz.smash.configuration;

import org.omg.SendingContext.RunTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import sun.java2d.loops.ProcessPath;

import java.util.*;

@Configuration
@ComponentScan("com.xworkz.smash.servicess")
public class ServiceConfig {

    public ServiceConfig(){
        System.out.println(" serviceconfig created......");
    }

    @Bean
    public TimeZone timeZone(){
        System.out.println("-----------------------------------------------------------");
        System.out.println("Running bean method timeZone");
        return TimeZone.getTimeZone("Asia/kolkata");
    }
    @Bean
    public ClassLoader classLoader(){
        System.out.println("Running bean method classLoader");
        return getClass().getClassLoader();
    }
    @Bean
    public InheritableThreadLocal<String> inheritableThreadLocal(){
        System.out.println("Running bean method inheritableThreadLocal");
        return new InheritableThreadLocal<>();
    }
    @Bean
    public BitSet bitSet(){
        System.out.println("Running bean method bitSet");
        return new BitSet();
    }
    @Bean
    public TreeSet<String> treeSet(){
        System.out.println("Running bean method treeSet");
        return new TreeSet<>();
    }
    @Bean
    public TreeMap<Integer,String> treeMap(){
        System.out.println("Running bean method treeMap");
        return new TreeMap<>();
    }
    @Bean
    public LinkedHashMap<String,Integer> linkedHashMap(){
        System.out.println("Running bean method linkedHashMap");
        return new LinkedHashMap<>();
    }
    @Bean
    public LinkedHashSet<String> linkedHashSet(){
        System.out.println("Running bean method linkedHashSet");
        return new LinkedHashSet<>();
    }
    @Bean
    public Stack<Integer> stack(){
        System.out.println("Running bean method stack");
        return new Stack<>();
    }

    @Bean
    public Vector<String> vector(){
        System.out.println("Running bean method vector");
        return new Vector<>();
    }

}
