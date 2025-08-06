package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class MilkComponent {
    public MilkComponent(){
        System.out.println("No-argu const of MilkComponent");
    }
    @RequestMapping("/milk")
    public String milkMethod(@RequestParam String type, @RequestParam int quantity, @RequestParam double fatPercentage,
                             @RequestParam double price, @RequestParam String brand) {

        System.out.println("Milk Type: " + type);
        System.out.println("Quantity (ml): " + quantity);
        System.out.println("Fat Percentage: " + fatPercentage + "%");
        System.out.println("Price: ₹" + price);
        System.out.println("Brand: " + brand);
        System.out.println("Method of MilkComponent is called");

        return "milk.jsp";
    }
}
