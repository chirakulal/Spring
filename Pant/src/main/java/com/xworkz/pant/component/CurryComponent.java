package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class CurryComponent {

    public CurryComponent(){
        System.out.println("No-argu const of CurryComponent");
    }
    @RequestMapping("/curry")

    public String curryMethod(@RequestParam String name, @RequestParam String spiceLevel,
                              @RequestParam String mainIngredient, @RequestParam String type,
                              @RequestParam int quantity) {

        System.out.println("Curry Name: " + name);
        System.out.println("Spice Level: " + spiceLevel);
        System.out.println("Main Ingredient: " + mainIngredient);
        System.out.println("Curry Type: " + type);
        System.out.println("Quantity (ml): " + quantity);
        System.out.println("Method of CurryComponent is called");

        return "curry.jsp";
    }

}
