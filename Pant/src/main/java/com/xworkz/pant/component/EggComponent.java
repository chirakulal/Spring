package com.xworkz.pant.component;

import com.xworkz.pant.dto.EggDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class EggComponent {

    public EggComponent(){
        System.out.println("No-argu const of EggComponent...");
    }
    @RequestMapping("/egg")
    public String eggMethod(EggDTO eggDTO, Model model) {

        System.out.println("Egg Type: " + eggDTO.getType());
        System.out.println("Size : " + eggDTO.getSize());
        System.out.println("Price : " + eggDTO.getPrice());
        System.out.println("Color: " + eggDTO.getColor());
        System.out.println("Brand: " + eggDTO.getBrand());
        System.out.println("Method of EggComponent is called");

        model.addAttribute("dto",eggDTO);
        return "EggResult";
    }
}
