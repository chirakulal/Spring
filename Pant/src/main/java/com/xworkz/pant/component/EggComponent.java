package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class EggComponent {

    public EggComponent(){
        System.out.println("No-argu const of EggComponent...");
    }
    @RequestMapping("/egg")
    public String eggMethod(){
        System.out.println("method of EggComponent is called..");
        return "egg.jsp";
    }
}
