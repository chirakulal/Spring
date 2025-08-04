package com.xworkz.pant.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.pant")
public class PantConfig {

    public PantConfig(){
        System.out.println("Created Config by spring");
    }
}
