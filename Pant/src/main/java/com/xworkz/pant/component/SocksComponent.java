package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class SocksComponent {
    public SocksComponent(){
        System.out.println("No-argu const of SocksComponent");
    }
    @RequestMapping("/socks")
    public String socksMethod(){
        System.out.println("method of SocksComponent is called");
        return "socks.jsp";
    }
}
