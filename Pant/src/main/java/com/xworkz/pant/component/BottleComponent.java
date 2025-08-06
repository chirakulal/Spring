package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class BottleComponent {

    public BottleComponent(){
        System.out.println("No-arg const of BottleComponent");
    }

    @RequestMapping("/bottle")
    public String BottleMethod(@RequestParam String material, @RequestParam String capacity,@RequestParam String color,@RequestParam String shape, @RequestParam int price){
        System.out.println("Bottle material :"+material);
        System.out.println("Bottle capacity :"+capacity);
        System.out.println("Bottle color :"+color);
        System.out.println("Bottle shape :"+shape);
        System.out.println("Bottle price :"+price);




        System.out.println("method of BottleComponent is called");
        return "bottle.jsp";
    }
}
