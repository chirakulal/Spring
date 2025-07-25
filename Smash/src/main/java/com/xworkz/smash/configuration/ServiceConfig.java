package com.xworkz.smash.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.smash.services")
public class ServiceConfig {

    public ServiceConfig(){
        System.out.println("Running serviceconfig created");
    }
}
