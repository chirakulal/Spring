package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class SocksComponent {
    public SocksComponent(){
        System.out.println("No-argu const of SocksComponent");
    }
    @RequestMapping("/socks")
    public String socksMethod(@RequestParam int size, @RequestParam String material,
                              @RequestParam String color, @RequestParam String lengthType,
                              @RequestParam String brand) {

        System.out.println("Socks Size: " + size);
        System.out.println("Material: " + material);
        System.out.println("Color: " + color);
        System.out.println("Length Type: " + lengthType);
        System.out.println("Brand: " + brand);
        System.out.println("Method of SocksComponent is called");

        return "socks.jsp";
    }
}
