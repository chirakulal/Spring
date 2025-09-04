package com.xworkz.customerForm.repository;

import com.xworkz.customerForm.entity.CustomerEntity;


public interface AuthenticationRepository {

    boolean save(CustomerEntity customerEntity);

    CustomerEntity sigIn(String name);

    boolean updatePassword(String email,String password);

    CustomerEntity getByEmail(String email);

    boolean update(CustomerEntity customerEntity);

    void updateCustomer(CustomerEntity customerEntity);

    Long emailCount(String email);

    Long countPhoneNumber(long phoneNumber);

    Long countName(String name);
}
