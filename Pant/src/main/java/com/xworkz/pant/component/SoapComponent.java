package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class SoapComponent {
    public SoapComponent(){
        System.out.println("No-arg const of SoapComponent");
    }

    @RequestMapping("/soap")
    public String soapMethod(@RequestParam String name, @RequestParam int weight,
                             @RequestParam String fragrance, @RequestParam double price,
                             @RequestParam String brand) {

        System.out.println("Soap Name: " + name);
        System.out.println("Weight (g): " + weight);
        System.out.println("Fragrance: " + fragrance);
        System.out.println("Price: ₹" + price);
        System.out.println("Brand: " + brand);
        System.out.println("Method of SoapComponent is called");

        return "soap.jsp";
    }
}
