package com.xworkz.customerForm.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    @NotNull(message = "Name should not be empty")
    @Size(min=3,max=20,message = "name should contain between 3-20 character")
    private String name;

    @NotNull(message = "Email should not be empty")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$",message = "Email should send with @gmail.com")
    private String email;

    @NotNull(message = "PhoneNumber should not be null")
    @Min(value = 1000000000L, message = "Phone number should be 10 digits")
    @Max(value = 99999999999L, message = "Phone number should be 10 digits")
    private Long phoneNumber;

    @NotNull(message = "Password should contain at least 6 character")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])?[A-Za-z\\d!@#$%^&*]{6,}$")
    private String password;

    @NotNull(message = "ConfirmPassword should not be empty")
    private String confirmPassword;

    @NotNull(message = "Age should not be empty")
    @Min(value = 18, message = "Age should be greater than 18")
    @Max(value = 140, message = "Age should be less than 140")
    private int age;

    @NotNull(message = "Address should not be empty")
    @Size(min=3, max=1000, message = "Address should be 3to1000 character")
    private String address;

    @NotNull(message = "gender should not be empty")
    private String gender;

    private String imagePath;




}
