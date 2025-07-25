package com.xworkz.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.spring.internal")
public class SmashConfiguration {

    public SmashConfiguration(){
        System.out.println("Created a configuration.......");
    }
}
