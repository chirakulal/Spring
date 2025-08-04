package com.xworkz.pant.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class PantConfigIntial extends AbstractAnnotationConfigDispatcherServletInitializer {

    public PantConfigIntial(){
        System.out.println("ConfigInitial is created...");
    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{PantConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/on","/soap","/butter","/bottle","/shoe","/chappal","/socks","/chutney",
                "/onion","/milk","/curry","/biryani","/parota","/egg"};
    }
}
