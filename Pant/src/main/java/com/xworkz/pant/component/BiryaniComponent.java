package com.xworkz.pant.component;

import com.xworkz.pant.dto.BiryaniDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BiryaniComponent {

    public BiryaniComponent(){
        System.out.println("No-argu const of BriyaniComponent...");
    }
    @RequestMapping("/biryani")
    public String biryaniMethod(BiryaniDTO biryaniDTO){
        System.out.println("Briyani type: "+biryaniDTO.getType());
        System.out.println("Spice-level: "+biryaniDTO.getSpice());
        System.out.println("Accompaniments : "+biryaniDTO.getAccompaniments());
        System.out.println("briyani size :"+biryaniDTO.getSize());
        System.out.println("Rice type: "+biryaniDTO.getRice());
        System.out.println("method of BriyaniComponent is called..");
        return "briyani.jsp";
    }
}
