package com.xworkz.pant.component;

import com.xworkz.pant.dto.BottleDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BottleComponent {

    public BottleComponent(){
        System.out.println("No-arg const of BottleComponent");
    }

    @RequestMapping("/bottle")
    public String BottleMethod(BottleDTO bottleDTO, Model model){
        System.out.println("Bottle material :"+bottleDTO.getMaterial());
        System.out.println("Bottle capacity :"+bottleDTO.getCapacity());
        System.out.println("Bottle color :"+bottleDTO.getColor());
        System.out.println("Bottle shape :"+bottleDTO.getShape());
        System.out.println("Bottle price :"+bottleDTO.getPrice());

        System.out.println("method of BottleComponent is called");

        model.addAttribute("dto",bottleDTO);
        return "BottelResult";
    }
}
