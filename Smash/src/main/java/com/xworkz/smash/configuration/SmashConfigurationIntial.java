package com.xworkz.smash.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SmashConfigurationIntial extends AbstractAnnotationConfigDispatcherServletInitializer {

    public SmashConfigurationIntial(){
        System.out.println("Created a intial of Spring......");
    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SmashConfig.class, SmashConfig2.class, GunConfig.class, processConfig.class, ServiceConfig.class, BikeConfig.class, BulletConfig.class, SmashConfig3.class, SmashConfig4.class, SmashConfig5.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
