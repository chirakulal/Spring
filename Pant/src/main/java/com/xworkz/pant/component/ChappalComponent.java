package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ChappalComponent {
    public ChappalComponent(){
        System.out.println("No-argu const of ChappalComponent");
    }
    @RequestMapping("/chappal")
    public String chappalMethod(){
        System.out.println("method of ChappalComponent is called");
        return "chappal.jsp";
    }
}
