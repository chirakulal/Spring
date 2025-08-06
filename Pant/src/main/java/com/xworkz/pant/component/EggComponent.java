package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class EggComponent {

    public EggComponent(){
        System.out.println("No-argu const of EggComponent...");
    }
    @RequestMapping("/egg")
    public String eggMethod(@RequestParam String type, @RequestParam int size,
                            @RequestParam long price, @RequestParam String color,
                            @RequestParam String brand) {

        System.out.println("Egg Type: " + type);
        System.out.println("Size : " + size);
        System.out.println("Price : " + price);
        System.out.println("Color: " + color);
        System.out.println("Brand: " + brand);
        System.out.println("Method of EggComponent is called");

        return "egg.jsp";
    }
}
