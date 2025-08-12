package com.xworkz.pant.component;

import com.xworkz.pant.dto.SoapDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SoapComponent {
    public SoapComponent(){
        System.out.println("No-arg const of SoapComponent");
    }

    @RequestMapping("/soap")
    public String soapMethod(SoapDTO soapDTO, Model model) {

        System.out.println("Soap Name: " + soapDTO.getName());
        System.out.println("Weight (g): " + soapDTO.getWeight());
        System.out.println("Fragrance: " + soapDTO.getFragrance());
        System.out.println("Price: ₹" + soapDTO.getPrice());
        System.out.println("Brand: " + soapDTO.getBrand());
        System.out.println("Method of SoapComponent is called");

        model.addAttribute("dto",soapDTO);
        return "SoapResult";
    }
}
