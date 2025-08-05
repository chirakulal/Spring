package com.xworkz.facewash.configuration;

import com.xworkz.facewash.component.BagComponent;
import com.xworkz.facewash.component.ShoeComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.facewash")
public class AppConfig {

    public AppConfig(){
        System.out.println("Config class create dby spring....");
    }

    @Bean
    public BagComponent bagComponent(){
        return new BagComponent();
    }

    @Bean
    public ShoeComponent shoeComponent(){
        return new ShoeComponent();
    }
}
