package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class LinkComponent {

    public LinkComponent(){
        System.out.println("no-argu const of a LinkComponent");
    }

    @RequestMapping("/on")
    public String linkMethod(@RequestParam String fname,
                             @RequestParam String lname,
                             @RequestParam long number,
                             @RequestParam String email,
                             @RequestParam String address){

        System.out.println("First Name :" + fname);
        System.out.println("Last Name :" + lname);
        System.out.println("Number :" + number);
        System.out.println("Email : "+email);
        System.out.println("Address :"+address);
        System.out.println("method in link is called..");
        return "link.jsp";
    }
}
