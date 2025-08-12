package com.xworkz.pant.component;

import com.xworkz.pant.dto.SockesDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SocksComponent {
    public SocksComponent(){
        System.out.println("No-argu const of SocksComponent");
    }
    @RequestMapping("/socks")
    public String socksMethod(SockesDTO sockesDTO, Model model) {

        System.out.println("Socks Size: " + sockesDTO.getSize());
        System.out.println("Material: " + sockesDTO.getMaterial());
        System.out.println("Color: " + sockesDTO.getColor());
        System.out.println("Length Type: " + sockesDTO.getLengthType());
        System.out.println("Brand: " + sockesDTO.getBrand());
        System.out.println("Method of SocksComponent is called");

        model.addAttribute("dto",sockesDTO);
        return "SocksResult";
    }
}
