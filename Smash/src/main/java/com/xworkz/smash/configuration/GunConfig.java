package com.xworkz.smash.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.smash.handler")
public class GunConfig {

    public GunConfig(){
        System.out.println("Running gunconfig created...");
    }
}
