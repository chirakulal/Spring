package com.xworkz.pant.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class ButterComponent {

    public ButterComponent(){
        System.out.println("No-argu const of ButterComponent");
    }
    @RequestMapping("/butter")
    public String butterMethod(@RequestParam String type,@RequestParam String fatContent,
                               @RequestParam String saltType,@RequestParam String packageSize,@RequestParam String brand){

        System.out.println("Butter type: "+type);
        System.out.println("Butter fatContent: "+fatContent);
        System.out.println("Butter saltType: "+saltType);
        System.out.println("Butter packageSize: "+packageSize);
        System.out.println("Butter brand: "+brand);

        System.out.println("method of butterComponent is called");
        return "butter.jsp";
    }
}
