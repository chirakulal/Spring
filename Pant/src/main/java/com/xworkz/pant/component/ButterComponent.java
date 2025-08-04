package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ButterComponent {

    public ButterComponent(){
        System.out.println("No-argu const of ButterComponent");
    }
    @RequestMapping("/butter")
    public String butterMethod(){
        System.out.println("method of butterComponent is called");
        return "butter.jsp";
    }
}
