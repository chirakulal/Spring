package com.xworkz.pant.component;

import com.xworkz.pant.dto.MilkDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MilkComponent {
    public MilkComponent(){
        System.out.println("No-argu const of MilkComponent");
    }
    @RequestMapping("/milk")
    public String milkMethod(MilkDTO milkDTO) {

        System.out.println("Milk Type: " + milkDTO.getType());
        System.out.println("Quantity (ml): " + milkDTO.getQuantity());
        System.out.println("Fat Percentage: " + milkDTO.getFatPercentage() + "%");
        System.out.println("Price: ₹" + milkDTO.getPrice());
        System.out.println("Brand: " + milkDTO.getBrand());
        System.out.println("Method of MilkComponent is called");

        return "milk.jsp";
    }
}
