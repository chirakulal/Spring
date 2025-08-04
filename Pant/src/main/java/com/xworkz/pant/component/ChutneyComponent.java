package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ChutneyComponent {
    public ChutneyComponent(){
        System.out.println("No-argu const of ChutneyComponent");
    }
    @RequestMapping("/chutney")
    public String chutneyMethod(){
        System.out.println("method of ChutneyComponent is called");
        return "chutney.jsp";
    }
}
