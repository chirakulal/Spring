package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class MilkComponent {
    public MilkComponent(){
        System.out.println("No-argu const of MilkComponent");
    }
    @RequestMapping("/milk")
    public String milkMethod(){
        System.out.println("method of MilkComponent is called");
        return "milk.jsp";
    }
}
