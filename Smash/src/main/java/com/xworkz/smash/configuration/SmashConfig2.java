package com.xworkz.smash.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.smash.internal")
public class SmashConfig2 {
    public SmashConfig2(){
        System.out.println("SmashConfig config is createdd..");
    }
}
