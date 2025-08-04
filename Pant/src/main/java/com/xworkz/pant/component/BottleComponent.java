package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class BottleComponent {

    public BottleComponent(){
        System.out.println("No-arg const of BottleComponent");
    }

    @RequestMapping("/bottle")
    public String BottleMethod(){
        System.out.println("method of BottleComponent is called");
        return "bottle.jsp";
    }
}
