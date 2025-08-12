package com.xworkz.pant.component;

import com.xworkz.pant.dto.ButterDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ButterComponent {

    public ButterComponent(){
        System.out.println("No-argu const of ButterComponent");
    }
    @RequestMapping("/butter")
    public String butterMethod(ButterDTO butterDTO, Model model){

        System.out.println("Butter type: "+butterDTO.getType());
        System.out.println("Butter fatContent: "+butterDTO.getFatContent());
        System.out.println("Butter saltType: "+butterDTO.getSaltType());
        System.out.println("Butter packageSize: "+butterDTO.getPackageSize());
        System.out.println("Butter brand: "+butterDTO.getBrand());

        System.out.println("method of butterComponent is called");

        model.addAttribute("dto",butterDTO);
        return "ButterResult";
    }
}
