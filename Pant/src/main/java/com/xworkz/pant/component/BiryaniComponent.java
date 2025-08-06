package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class BiryaniComponent {

    public BiryaniComponent(){
        System.out.println("No-argu const of BriyaniComponent...");
    }
    @RequestMapping("/biryani")
    public String biryaniMethod(@RequestParam String type,@RequestParam String spice,@RequestParam String size,
                                @RequestParam String accompaniments,@RequestParam String rice){
        System.out.println("Briyani type: "+type);
        System.out.println("Spice-level: "+spice);
        System.out.println("Accompaniments : "+accompaniments);
        System.out.println("briyani size :"+size);
        System.out.println("Rice type: "+rice);
        System.out.println("method of BriyaniComponent is called..");
        return "briyani.jsp";
    }
}
