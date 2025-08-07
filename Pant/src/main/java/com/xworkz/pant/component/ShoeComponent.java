package com.xworkz.pant.component;

import com.xworkz.pant.dto.ShoeDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ShoeComponent {

    public ShoeComponent(){
        System.out.println("No-arg const of ShoeComponent");
    }

    @RequestMapping("/shoe")
    public String shoeMethod(ShoeDTO shoeDTO) {

        System.out.println("Shoe Size: " + shoeDTO.getSize());
        System.out.println("Material: " + shoeDTO.getMaterial());
        System.out.println("Color: " + shoeDTO.getColor());
        System.out.println("Type: " + shoeDTO.getType());
        System.out.println("Brand: " + shoeDTO.getBrand());
        System.out.println("Method of ShoeComponent is called");

        return "shoe.jsp";
    }
}
