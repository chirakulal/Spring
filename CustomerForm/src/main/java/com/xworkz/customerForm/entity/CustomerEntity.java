package com.xworkz.customerForm.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_details")
@NamedQuery(name = "getPasswordAndName",query = "Select entity from CustomerEntity entity where entity.name = :nameBy")
@NamedQuery(name = "getAllByEmail", query = "Select entity from CustomerEntity entity where entity.email= :emailBY")
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
}
