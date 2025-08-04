package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ShoeComponent {

    public ShoeComponent(){
        System.out.println("No-arg const of ShoeComponent");
    }

    @RequestMapping("/shoe")
    public String shoeMethod(){
        System.out.println("method of ShoeComponent is called");
        return "shoe.jsp";
    }
}
