package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class ChappalComponent {
    public ChappalComponent(){
        System.out.println("No-argu const of ChappalComponent");
    }
    @RequestMapping("/chappal")
    public String chappalMethod(@RequestParam int size,@RequestParam String material,@RequestParam String color,
                                @RequestParam String type,@RequestParam String brand){
        System.out.println("Chappal size :"+size);
        System.out.println("Chappal material :"+material);
        System.out.println("Chappal color :"+color);
        System.out.println("Chappal type :"+type);
        System.out.println("Chappal brand :"+brand);
        System.out.println("method of ChappalComponent is called");
        return "chappal.jsp";
    }
}
