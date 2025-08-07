package com.xworkz.pant.component;

import com.xworkz.pant.dto.ChappalDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ChappalComponent {
    public ChappalComponent(){
        System.out.println("No-argu const of ChappalComponent");
    }
    @RequestMapping("/chappal")
    public String chappalMethod(ChappalDTO chappalDTO){
        System.out.println("Chappal size :"+chappalDTO.getSize());
        System.out.println("Chappal material :"+chappalDTO.getMaterial());
        System.out.println("Chappal color :"+chappalDTO.getColor());
        System.out.println("Chappal type :"+chappalDTO.getType());
        System.out.println("Chappal brand :"+chappalDTO.getBrand());
        System.out.println("method of ChappalComponent is called");
        return "chappal.jsp";
    }
}
