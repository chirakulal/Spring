package com.xworkz.customerForm.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_details")
@NamedQuery(name = "getPasswordAndName",query = "Select entity from CustomerEntity entity where entity.name = :nameBy")
@NamedQuery(name = "getAllByEmail", query = "Select entity from CustomerEntity entity where entity.email= :emailBY")
@NamedQuery(name ="countEmail",query ="select count(e.email) from CustomerEntity e where email=:email" )
@NamedQuery(name ="countPhoneNumber",query ="select count(e.phoneNumber) from CustomerEntity e where phoneNumber=:phoneNumber" )
@NamedQuery(name ="countName",query ="select count(e.name) from CustomerEntity e where name=:name" )
public class CustomerEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcustomer_details")
    private  int id;

    @Column(name ="name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private String gender;

    @Column(name = "failedAttempt")
    private int failedAttempt =0;

    @Column(name = "accountLocked")
    private int accountLocked =0;

    @Column(name = "lock_time")
    private LocalDateTime lockTime;
}
