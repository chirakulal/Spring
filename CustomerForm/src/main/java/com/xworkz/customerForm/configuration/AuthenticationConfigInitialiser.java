package com.xworkz.customerForm.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AuthenticationConfigInitialiser extends AbstractAnnotationConfigDispatcherServletInitializer {

    public AuthenticationConfigInitialiser(){
        System.out.println("Spring intialiser is created....");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AuthenticationConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
