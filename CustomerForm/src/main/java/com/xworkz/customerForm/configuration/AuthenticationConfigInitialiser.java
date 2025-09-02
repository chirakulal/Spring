package com.xworkz.customerForm.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Slf4j
public class AuthenticationConfigInitialiser extends AbstractAnnotationConfigDispatcherServletInitializer {

    public AuthenticationConfigInitialiser(){
        log.info("Spring intialiser is created....");
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
