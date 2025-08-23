package com.xworkz.customerForm.service;

import com.xworkz.customerForm.dto.CustomerDTO;
import com.xworkz.customerForm.entity.CustomerEntity;
import com.xworkz.customerForm.repository.AuthenticationRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.constraints.Size;
import java.util.Properties;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    AuthenticationRepoImpl authenticationRepo;

   BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean saveAndValidate(CustomerDTO customerDTO) {

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setName(customerDTO.getName());
        customerEntity.setEmail(customerDTO.getEmail());
        sendEmail(customerEntity.getEmail());
        customerEntity.setPassword(bCryptPasswordEncoder.encode(customerDTO.getPassword()));
        customerEntity.setPhoneNumber(customerDTO.getPhoneNumber());
        customerEntity.setAge(customerDTO.getAge());
        customerEntity.setAddress(customerDTO.getAddress());
        customerEntity.setGender(customerDTO.getGender());


        return authenticationRepo.save(customerEntity);
    }

    @Override
    public CustomerEntity signIn(String name,String password) {

     CustomerEntity customerEntity=   authenticationRepo.sigIn(name);

     if( bCryptPasswordEncoder.matches(password,customerEntity.getPassword()) && customerEntity.getName().equals(name)){
         System.out.println("Password and name are matched");
         return customerEntity;
     }

     return customerEntity;
    }


    @Override
    public boolean updatePassword(String email, String password) {
        return authenticationRepo.updatePassword(email,bCryptPasswordEncoder.encode(password));
    }

    private void sendEmail(String email){
        final String username = "chirashreelk@gmail.com";
        final String password = "dsjh qqwc gkos ebto";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Registration Successfull");
            message.setText("Dear ,"
                    + "Welcome to xworkz...");

            Transport.send(message);

            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CustomerEntity getByEmail(String email) {


        return authenticationRepo.getByEmail(email);
    }

    @Override
    public boolean update(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customerDTO.getName());
        customerEntity.setEmail(customerDTO.getEmail());
        customerEntity.setAge(customerDTO.getAge());
        customerEntity.setAddress(customerDTO.getAddress());
        customerEntity.setPhoneNumber(customerDTO.getPhoneNumber());
        customerEntity.setGender(customerDTO.getGender());
        System.out.println(customerEntity);
        return  authenticationRepo.update(customerEntity);
    }
}

