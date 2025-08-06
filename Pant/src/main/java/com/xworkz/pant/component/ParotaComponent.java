package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class ParotaComponent {

    public ParotaComponent(){
        System.out.println("No-argu const of ParotaComponent...");
    }
    @RequestMapping("/parota")
    public String parotaMethod(@RequestParam String type, @RequestParam int size,
                               @RequestParam int layers, @RequestParam boolean stuffed,
                               @RequestParam String flour) {

        System.out.println("Parota Type: " + type);
        System.out.println("Size (inches): " + size);
        System.out.println("Number of Layers: " + layers);
        System.out.println("Is Stuffed: " + stuffed);
        System.out.println("Flour Type: " + flour);
        System.out.println("Method of ParotaComponent is called");

        return "parota.jsp";
    }
}
