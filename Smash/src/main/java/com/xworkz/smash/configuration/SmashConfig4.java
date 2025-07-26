package com.xworkz.smash.configuration;

import org.springframework.context.annotation.Bean;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.nio.charset.Charset;
import java.security.CodeSource;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public class SmashConfig4 {

    public SmashConfig4(){
        System.out.println(" SmashConfig4 created..........");
    }
    @Bean
    public DocumentBuilderFactory documentBuilder(){
        System.out.println("-----------------------------------------------------------");
        System.out.println("Running bean method documentBuilder");
        return DocumentBuilderFactory.newInstance();
    }
    @Bean
    public TransformerFactory transformerFactory(){
        System.out.println("Running bean method transformerFactory");
        return TransformerFactory.newInstance();
    }
    @Bean
    public SAXParserFactory saxParserFactory(){
        System.out.println("Running bean method saxParserFactory");
        return SAXParserFactory.newInstance();
    }
    @Bean
    public XPathFactory xPathConstants(){
        System.out.println("Running bean method xPathConstants");
        return XPathFactory.newInstance();
    }
    @Bean
    public CodeSource codeSource(){
        return this.getClass().getProtectionDomain().getCodeSource();
    }
//    @Bean
//    public XPath xPath(){
//        System.out.println("Running bean method xPath");
//        return xPath();
//    }
    @Bean
    public Clock systemClock(){
        System.out.println("Running bean method systemClock");
        return Clock.systemUTC();
    }
    @Bean
    public Charset charset(){
        System.out.println("Running bean method charset");
        return Charset.defaultCharset();
    }
    @Bean
    public ZoneId zoneId(){
        System.out.println("Running bean method zoneId");
        return ZoneId.systemDefault();
    }
    @Bean
    public Duration duration(){
        System.out.println("Running bean method duration");
        return Duration.ofSeconds(60);
    }
    @Bean
    public Instant instant(){
        System.out.println("Running bean method instant");
        return Instant.now();
    }

}
