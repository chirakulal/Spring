package com.xworkz.pant.component;

import com.xworkz.pant.dto.LInkDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LinkComponent {

    public LinkComponent(){
        System.out.println("no-argu const of a LinkComponent");
    }

    @RequestMapping("/on")
    public String linkMethod(LInkDTO lInkDTO, Model model){

        System.out.println("First Name :" + lInkDTO.getFname());
        System.out.println("Last Name :" + lInkDTO.getLname());
        System.out.println("Number :" + lInkDTO.getNumber());
        System.out.println("Email : "+lInkDTO.getEmail());
        System.out.println("Address :"+lInkDTO.getAddress());
        System.out.println("method in link is called..");

        model.addAttribute("dto",lInkDTO);
        return "LinkResult";
    }
}
