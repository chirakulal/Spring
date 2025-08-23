package com.xworkz.customerForm.component;

import com.xworkz.customerForm.dto.CustomerDTO;
import com.xworkz.customerForm.entity.CustomerEntity;
import com.xworkz.customerForm.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    public AuthenticationController(){
        System.out.println("Controller..............");
    }

    @RequestMapping("signup")
    public ModelAndView saveAndValidate(@Valid CustomerDTO customerDTO, BindingResult bindingResult, ModelAndView modelAndView){

        System.out.println(customerDTO);
        if(!customerDTO.getPassword().equals(customerDTO.getConfirmPassword())){
            modelAndView.addObject("error","Password and Confirm password does not match");
            modelAndView.addObject("dto",customerDTO);
            modelAndView.setViewName("SignUp");
            return modelAndView;
        }

        if(bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError objectError : errors){
                modelAndView.addObject("error",objectError.getDefaultMessage());
                modelAndView.setViewName("SignUp");
                modelAndView.addObject("dto",customerDTO);
                return modelAndView;
            }
        }

       Boolean result = authenticationService.saveAndValidate(customerDTO);
        System.out.println(result);
        if(result) {
            modelAndView.addObject("success", "Registered Successfully");
            modelAndView.setViewName("SignUp");

        }
        return modelAndView;
    }

    @RequestMapping("signin")
    public ModelAndView signIn(@RequestParam  String name, @RequestParam String password, ModelAndView modelAndView,HttpSession httpSession){

        if(name.isEmpty()||password.isEmpty()){
            modelAndView.addObject("error","Email or Password cannot be empty");
            modelAndView.setViewName("SignIn");
            return modelAndView;
        }

      CustomerEntity customerEntity =  authenticationService.signIn(name,password);
        if(customerEntity==null){
            System.out.println("Match not found");
            modelAndView.addObject("error","User not found");
            modelAndView.setViewName("SignIn");
            return modelAndView;
        }
        httpSession.setAttribute("email",customerEntity.getEmail());
        System.out.println("Match found");
        modelAndView.addObject("success","SignIn successfully");
        modelAndView.addObject("username",customerEntity.getName());
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping("resetpassword")
    public ModelAndView updatePassword(@RequestParam String email,@RequestParam String password,@RequestParam String confirmPassword ,ModelAndView modelAndView) {
        System.out.println(password);
        System.out.println(confirmPassword);

        if (!password.equals(confirmPassword)) {
            System.out.println("Password does not match");
            modelAndView.addObject("error", "Password and confirm password does not match");
            modelAndView.addObject("dto", email);
            modelAndView.setViewName("Forgetpassword");
            return modelAndView;
        }

      boolean result=  authenticationService.updatePassword(email,password);

        if(!result){
            System.out.println("update is unsuccessfully");
            modelAndView.addObject("error","Cannot be updated");
            modelAndView.setViewName("Forgetpassword");
        return modelAndView;
    }
        System.out.println("Updated Successfully");
        modelAndView.setViewName("SignIn");

        return modelAndView;

    }

    @RequestMapping("userdetails")
    public ModelAndView getUserDetails(ModelAndView modelAndView, HttpSession httpSession){

      String sessionEmail =(String)  httpSession.getAttribute("email");
      CustomerEntity customerEntity =     authenticationService.getByEmail(sessionEmail);

      if(customerEntity!=null){
          modelAndView.addObject("dto",customerEntity);
          modelAndView.setViewName("Update");
          return modelAndView;
      }
      modelAndView.addObject("error","User data is not fetched");
      modelAndView.setViewName("Update");


        return modelAndView;
    }

    @RequestMapping("updateProfile")
    public ModelAndView updateProfile(@Valid CustomerDTO customerDTO,BindingResult bindingResult,ModelAndView modelAndView){
//        if(bindingResult.hasErrors()){
//            List<ObjectError> errors = bindingResult.getAllErrors();
//            for (ObjectError objectError : errors){
//                modelAndView.addObject("error",objectError.getDefaultMessage());
//
//                modelAndView.addObject("dto",customerDTO);
//                modelAndView.setViewName("Update");
//                return modelAndView;
//            }
  //      }
        System.out.println(customerDTO);
       boolean result = authenticationService.update(customerDTO);
        if(!result){
            modelAndView.addObject("error","Cannot be update");
            modelAndView.addObject("dto",customerDTO);
            modelAndView.setViewName("Update");
        }
        modelAndView.addObject("success","Update Successfully");
        modelAndView.addObject("dto",customerDTO);
        modelAndView.setViewName("Update");


        return modelAndView;
    }

}
