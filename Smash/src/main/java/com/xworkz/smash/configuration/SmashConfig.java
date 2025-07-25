package com.xworkz.smash.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
@ComponentScan("com.xworkz.smash.external")
public class SmashConfig {

    public SmashConfig(){
        System.out.println("Created config class.....");

    }



    @Bean
    public String appName(){
        System.out.println("-------------------------------------------------------");
        System.out.println("Running bean method appName");

        return "AppName method..";
    }

    @Bean
    public Integer versions(){
        System.out.println("Running bean method versions");
        return 1;
    }

    @Bean
    public Double interestRate(){
        System.out.println("Running bean method interestRate");
        return 0.1;
    }

    @Bean
    public Boolean isProduction(){
        System.out.println("Running bean method isProduction");
        return false;
    }

    @Bean
    public Float number(){
        System.out.println("Running bean method number");
        return 12.1f;
    }
    @Bean
    public Long personNumber(){
        System.out.println("Running bean method personNumber");
        return 35182730L;
    }

    @Bean
    public List<String> states(){
        System.out.println("Running bean method states");
        return new ArrayList<>(Arrays.asList("Karnataka","TamilNadu","kerala","Telangana","Goa"));
    }

    @Bean
    public Set<Long> mobileNumber(){
        System.out.println("Running bean method mobileNumber");
        return new HashSet<>(Arrays.asList(1233455L,12684753L,487278L));
    }

    @Bean
    public Queue<String> taskQueue(){
        System.out.println("Running bean method taskQueue");
        return new LinkedList<>(Arrays.asList("task1","task2","task3"));
    }

    @Bean
    public Map<String,String> credentials(){
        System.out.println("Running bean method credentials");
        Map<String,String> map = new HashMap<>();
        map.put("add","subtract");
        map.put("multiply","divide");
        return map;
    }
}
