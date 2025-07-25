package com.xworkz.smash.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.smash.processor")
public class processConfig {
    public processConfig(){
        System.out.println("Running processConfig created...");
    }
}
