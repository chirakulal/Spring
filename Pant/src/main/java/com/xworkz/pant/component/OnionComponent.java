package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class OnionComponent {

    public OnionComponent(){
        System.out.println("No-argu const of OnionComponent");
    }
    @RequestMapping("/onion")
    public String onionMethod(@RequestParam String type, @RequestParam String color,
                              @RequestParam int weight, @RequestParam double price,
                              @RequestParam boolean imported) {

        System.out.println("Onion Type: " + type);
        System.out.println("Color: " + color);
        System.out.println("Weight (grams): " + weight);
        System.out.println("Price: ₹" + price);
        System.out.println("Imported: " + imported);
        System.out.println("Method of OnionComponent is called");

        return "onion.jsp";
    }

}
