package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ParotaComponent {

    public ParotaComponent(){
        System.out.println("No-argu const of ParotaComponent...");
    }
    @RequestMapping("/parota")
    public String biryaniMethod(){
        System.out.println("method of ParotaComponent is called..");
        return "parota.jsp";
    }
}
