package com.xworkz.customerForm.component;

import com.xworkz.customerForm.dto.CustomerDTO;
import com.xworkz.customerForm.entity.CustomerEntity;
import com.xworkz.customerForm.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    public AuthenticationController(){
        log.info("Controller..............");
    }

    @RequestMapping("signup")
    public ModelAndView saveAndValidate(@Valid CustomerDTO customerDTO, BindingResult bindingResult, ModelAndView modelAndView){

        log.info("Customer DTO: {}", customerDTO);

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
        log.info("Result: {}", result);
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


            log.info("Match not found");
            modelAndView.addObject("error","User not found");
            modelAndView.setViewName("SignIn");
            return modelAndView;
        }

        if (customerEntity.getAccountLocked() == 1) {
            log.info("Account is locked for: " + name);
            modelAndView.addObject("error",
                    "Your account has been locked due to 3 failed attempts. Please wait 24 hours .");
            modelAndView.setViewName("SignIn");
            return modelAndView;
        }


        httpSession.setAttribute("email",customerEntity.getEmail());
        log.info("Match found");
        modelAndView.addObject("success","SignIn successfully");
        modelAndView.addObject("username",customerEntity.getName());
        modelAndView.setViewName("home");
        return modelAndView;
    }





    @RequestMapping("resetpassword")
    public ModelAndView updatePassword(@RequestParam String email,@RequestParam String password,@RequestParam String confirmPassword ,ModelAndView modelAndView) {
        log.info(password);
        log.info(confirmPassword);

        if (!password.equals(confirmPassword)) {
            log.info("Password does not match");
            modelAndView.addObject("error", "Password and confirm password does not match");
            modelAndView.addObject("dto", email);
            modelAndView.setViewName("Forgetpassword");
            return modelAndView;
        }

        String result = authenticationService.updatePassword(email, password);

        if ("SUCCESS".equals(result)) {
            modelAndView.addObject("success", "Password updated successfully.");
            modelAndView.setViewName("SignIn");
        } else {
            modelAndView.addObject("error", result);
            modelAndView.setViewName("Forgetpassword");
        }

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
        log.info("Customer DTO: {}", customerDTO);

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



    // Step 1: Verify Email and Send OTP
    @RequestMapping("verifyUserEmail")
    public ModelAndView verifyEmail(String email, ModelAndView modelAndView, HttpSession session) {
        CustomerEntity customerEntity = authenticationService.getByEmail(email);

        if (customerEntity == null) {
            // Email not found → stay on login page
            modelAndView.setViewName("login");
            modelAndView.addObject("error", "Email does not exist!");
            return modelAndView;
        }

        // Save email in session for OTP validation
        session.setAttribute("loginEmailForOtp", email);

        // Send OTP
        authenticationService.sendOtp(email);

        // Redirect to verifyOtp.jsp
        modelAndView.setViewName("verifyOtp");
        modelAndView.addObject("email", email);

        return modelAndView;
    }

    // Step 2: Verify OTP
    @RequestMapping("otpVerify")
    public ModelAndView verifyOtp(String otp, ModelAndView view, HttpSession session) {
        String email = (String) session.getAttribute("loginEmailForOtp");
        boolean check = authenticationService.verifyOtp(email, otp);

        if (!check) {
            // Invalid OTP
            view.addObject("error", "Invalid OTP. Please try again!");
            view.addObject("email", email);
            view.setViewName("verifyOtp");
        } else {
            // OTP verified successfully
            CustomerEntity customerEntity = authenticationService.getByEmail(email);
            session.setAttribute("loginName", customerEntity.getName());
            session.setAttribute("loginEmail", customerEntity.getEmail());

            // You can either redirect immediately or show a success message before redirect
            view.addObject("message", "OTP Verified Successfully. Redirecting...");
            view.setViewName("home");
        }
        return view;
    }

    // Step 3: Resend OTP
    @RequestMapping("resendOtp")
    public ModelAndView resendOtp(ModelAndView view, HttpSession session) {
        String email = (String) session.getAttribute("loginEmailForOtp");

        authenticationService.sendOtp(email);

        view.addObject("email", email);
        view.addObject("message", "New OTP sent successfully");
        view.setViewName("verifyOtp"); // stay on verifyOtp.jsp
        return view;
    }

}


