package com.xworkz.customerForm.service;

import com.xworkz.customerForm.dto.CustomerDTO;
import com.xworkz.customerForm.entity.CustomerEntity;

public interface AuthenticationService {

    boolean saveAndValidate(CustomerDTO customerDTO);

    CustomerEntity signIn(String name, String password);

    String updatePassword(String email,String password);

    CustomerDTO getByEmail(String email);

    boolean update(CustomerDTO customerDTO);

    void updateCustomer(CustomerEntity customerEntity);

    boolean verifyOtp(String email, String otp);

    void sendOtp(String email);

    int emailCount(String email);

    int phoneNumberCount(long phoneNumber);

    int nameCount(String name);

//    void setProfile(String imagepath);

}
