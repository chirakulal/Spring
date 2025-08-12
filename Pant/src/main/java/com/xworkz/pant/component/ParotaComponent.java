package com.xworkz.pant.component;

import com.xworkz.pant.dto.ParatoDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ParotaComponent {

    public ParotaComponent(){
        System.out.println("No-argu const of ParotaComponent...");
    }
    @RequestMapping("/parota")
    public String parotaMethod(ParatoDTO paratoDTO, Model model) {

        System.out.println("Parota Type: " + paratoDTO.getType());
        System.out.println("Size (inches): " + paratoDTO.getSize());
        System.out.println("Number of Layers: " + paratoDTO.getLayers());
        System.out.println("Is Stuffed: " + paratoDTO.isStuffed());
        System.out.println("Flour Type: " + paratoDTO.getFlour());
        System.out.println("Method of ParotaComponent is called");

        model.addAttribute("dto",paratoDTO);
        return "ParotaResult";
    }
}
