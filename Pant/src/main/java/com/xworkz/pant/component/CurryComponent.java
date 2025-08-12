package com.xworkz.pant.component;

import com.xworkz.pant.dto.CurryDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CurryComponent {

    public CurryComponent(){
        System.out.println("No-argu const of CurryComponent");
    }
    @RequestMapping("/curry")

    public String curryMethod(CurryDTO curryDTO, Model model) {

        System.out.println("Curry Name: " + curryDTO.getName());
        System.out.println("Spice Level: " + curryDTO.getSpiceLevel());
        System.out.println("Main Ingredient: " + curryDTO.getMainIngredient());
        System.out.println("Curry Type: " + curryDTO.getType());
        System.out.println("Quantity (ml): " + curryDTO.getQuantity());
        System.out.println("Method of CurryComponent is called");

        model.addAttribute("dto",curryDTO);
        return "CurryResult";
    }

}
