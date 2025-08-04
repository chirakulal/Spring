package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class SoapComponent {
    public SoapComponent(){
        System.out.println("No-arg const of SoapComponent");
    }

    @RequestMapping("/soap")
    public String soapMethod(){
        System.out.println("Method of SoapComponent is called..");
        return "soap.jsp";
    }
}
