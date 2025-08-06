package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class ChutneyComponent {
    public ChutneyComponent(){
        System.out.println("No-argu const of ChutneyComponent");
    }
    @RequestMapping("/chutney")
    public String chutneyMethod(@RequestParam String type,
                                @RequestParam String spiceLevel,
                                @RequestParam String mainIngredient,
                                @RequestParam String color,
                                @RequestParam int quantity) {
        System.out.println("Chutney type: " + type);
        System.out.println("Spice level: " + spiceLevel);
        System.out.println("Main ingredient: " + mainIngredient);
        System.out.println("Chutney color: " + color);
        System.out.println("Chutney quantity (ml): " + quantity);
        System.out.println("method of ChutneyComponent is called");
        return "chutney.jsp";
    }

}
