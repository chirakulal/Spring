package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class CurryComponent {

    public CurryComponent(){
        System.out.println("No-argu const of CurryComponent");
    }
    @RequestMapping("/curry")
    public String curryMethod(){
        System.out.println("method of CurryComponent is called");
        return "chutney.jsp";
    }

}
