package com.xworkz.customerForm.repository;

import com.xworkz.customerForm.entity.CustomerEntity;


public interface AuthenticationRepository {

    boolean save(CustomerEntity customerEntity);

    CustomerEntity sigIn(String name);

    boolean updatePassword(String email,String password);

    CustomerEntity getByEmail(String email);

    boolean update(CustomerEntity customerEntity);
}
