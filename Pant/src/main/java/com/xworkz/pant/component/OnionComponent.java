package com.xworkz.pant.component;

import com.xworkz.pant.dto.OnionDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class OnionComponent {

    public OnionComponent(){
        System.out.println("No-argu const of OnionComponent");
    }
    @RequestMapping("/onion")
    public String onionMethod(OnionDTO onionDTO) {

        System.out.println("Onion Type: " + onionDTO.getType());
        System.out.println("Color: " + onionDTO.getColor());
        System.out.println("Weight (grams): " + onionDTO.getWeight());
        System.out.println("Price: ₹" + onionDTO.getPrice());
        System.out.println("Imported: " + onionDTO.isImported());
        System.out.println("Method of OnionComponent is called");

        return "onion.jsp";
    }

}
