package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class BiryaniComponent {

    public BiryaniComponent(){
        System.out.println("No-argu const of BriyaniComponent...");
    }
    @RequestMapping("/biryani")
    public String biryaniMethod(){
        System.out.println("method of BriyaniComponent is called..");
        return "briyani.jsp";
    }
}
