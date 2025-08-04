package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class OnionComponent {

    public OnionComponent(){
        System.out.println("No-argu const of OnionComponent");
    }
    @RequestMapping("/onion")
    public String onionMethod(){
        System.out.println("method of OnionComponent is called");
        return "onion.jsp";
    }

}
