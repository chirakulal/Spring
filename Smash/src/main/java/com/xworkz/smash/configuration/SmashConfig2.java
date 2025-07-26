package com.xworkz.smash.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Properties;

@Configuration
@ComponentScan("com.xworkz.smash.internal")
public class SmashConfig2 {
    public SmashConfig2(){
        System.out.println("SmashConfig config is createdd..");
    }

    @Bean
    public Properties sysProps(){
        System.out.println("-----------------------------------------------------------");
        System.out.println("Running bean method sysProps");
        Properties p = new Properties();
        p.setProperty("os","Windows");
        return p;
    }
    @Bean
    public Date currentDate(){
        System.out.println("Running bean method currentDate");
        return new Date();
    }
    @Bean
    public Short seats(){
        System.out.println("Running bean method mobileNumber");
        return 120;
    }
    @Bean
    public Character grade(){
        System.out.println("Running bean method seats");
        return 'A';
    }
    @Bean
    public Byte code(){
        System.out.println("Running bean method mobileNumber");
        return (byte) 10;
    }
    @Bean
    public File file(){
        System.out.println("Running bean method code");
        return new File("pom.xml");
    }
    @Bean
    public Path path(){
        System.out.println("Running bean method path");
        return Paths.get("your/file/path.txt");
    }
    @Bean
    public LocalDate today(){
        System.out.println("Running bean method today");
        return LocalDate.now();
    }

    @Bean
    public LocalTime nowTime(){
        System.out.println("Running bean method nowTime");
        return LocalTime.now();
    }
    @Bean
    public LocalDateTime timestamp(){
        System.out.println("Running bean method timestamp");
        return LocalDateTime.now();
    }
}
