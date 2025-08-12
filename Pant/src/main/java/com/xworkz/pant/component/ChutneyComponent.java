package com.xworkz.pant.component;

import com.xworkz.pant.dto.ChappalDTO;
import com.xworkz.pant.dto.ChutneyDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ChutneyComponent {
    public ChutneyComponent(){
        System.out.println("No-argu const of ChutneyComponent");
    }
    @RequestMapping("/chutney")
    public String chutneyMethod(ChutneyDTO chutneyDTO, Model model) {
        System.out.println("Chutney type: " + chutneyDTO.getType());
        System.out.println("Spice level: " + chutneyDTO.getSpiceLevel());
        System.out.println("Main ingredient: " + chutneyDTO.getMainIngredient());
        System.out.println("Chutney color: " + chutneyDTO.getColor());
        System.out.println("Chutney quantity (ml): " + chutneyDTO.getQuantity());
        System.out.println("method of ChutneyComponent is called");

        model.addAttribute("dto",chutneyDTO);
        return "ChutneyResult";
    }

}
