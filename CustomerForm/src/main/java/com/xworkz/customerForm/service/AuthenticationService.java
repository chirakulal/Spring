package com.xworkz.customerForm.service;

import com.xworkz.customerForm.dto.CustomerDTO;
import com.xworkz.customerForm.entity.CustomerEntity;

public interface AuthenticationService {

    boolean saveAndValidate(CustomerDTO customerDTO);

    CustomerEntity signIn(String name, String password);

    boolean updatePassword(String email,String password);

    CustomerEntity getByEmail(String email);

    boolean update(CustomerDTO customerDTO);
}
