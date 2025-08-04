package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class LinkComponent {

    public LinkComponent(){
        System.out.println("no-argu const of a LinkComponent");
    }

    @RequestMapping("/on")
    public String linkMethod(){
        System.out.println("method in link is called..");
        return "link.jsp";
    }
}
