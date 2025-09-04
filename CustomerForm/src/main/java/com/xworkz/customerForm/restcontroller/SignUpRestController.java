package com.xworkz.customerForm.restcontroller;

import com.xworkz.customerForm.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;

@Slf4j
@RestController
@RequestMapping("/")
public class SignUpRestController {

    @Autowired
   AuthenticationService authenticationService;

   @GetMapping("checkEmail/{email}")
    public String checkEmailCount(@PathVariable String email){
        log.info(email);
       int count =  authenticationService.emailCount(email);
       log.info(String.valueOf(count));
       if (count==0) return "";
       else return "Email already exist";
    }

    @GetMapping("checkPhoneNumber/{phoneNumber}")
    public  String checkPhoneNumber(@PathVariable long phoneNumber){
       log.info(String.valueOf(phoneNumber));
       int count = authenticationService.phoneNumberCount(phoneNumber);
       log.info(String.valueOf(count));
       if(count==0) return "";
       else return "PhoneNumber already exist";

    }

    @GetMapping("checkName/{name}")
    public  String checkName(@PathVariable String name){
        log.info(String.valueOf(name));
        int count = authenticationService.nameCount(name);
        log.info(String.valueOf(count));
        if(count==0) return "";
        else return "Name already exist";

    }
}
