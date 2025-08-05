package com.xworkz.facewash.runner;

import com.xworkz.facewash.component.BagComponent;
import com.xworkz.facewash.component.ShoeComponent;
import com.xworkz.facewash.configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainRunner {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        ShoeComponent shoeComponent = applicationContext.getBean(ShoeComponent.class);
        shoeComponent.walk();
    }
}
