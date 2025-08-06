package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class ShoeComponent {

    public ShoeComponent(){
        System.out.println("No-arg const of ShoeComponent");
    }

    @RequestMapping("/shoe")
    public String shoeMethod(@RequestParam int size, @RequestParam String material,
                             @RequestParam String color, @RequestParam String type,
                             @RequestParam String brand) {

        System.out.println("Shoe Size: " + size);
        System.out.println("Material: " + material);
        System.out.println("Color: " + color);
        System.out.println("Type: " + type);
        System.out.println("Brand: " + brand);
        System.out.println("Method of ShoeComponent is called");

        return "shoe.jsp";
    }
}
