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
import java.time.LocalDateTime;
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
        if (customerEntity == null) {
            return null;
        }
        if (customerEntity.getAccountLocked() == 1) {
            LocalDateTime lockTime = customerEntity.getLockTime();
            if (lockTime != null) {
                if (lockTime.plusHours(24).isBefore(LocalDateTime.now())) {

                    customerEntity.setAccountLocked(0);
                    customerEntity.setFailedAttempt(0);
                    customerEntity.setLockTime(null);
                    authenticationRepo.updateCustomer(customerEntity);
                    System.out.println("Account auto-unlocked after 24h for: " + name);
                } else {
                    System.out.println("Account still locked for: " + name);
                    return customerEntity;
                }
            } else {
                return customerEntity;
            }
        }

        if(customerEntity.getAccountLocked()==1){
            LocalDateTime localDateTime = customerEntity.getLockTime();

            if(localDateTime!=null) {
                if (localDateTime.plusHours(24).isBefore(LocalDateTime.now())) {
                    customerEntity.setAccountLocked(0);
                    customerEntity.setFailedAttempt(0);
                    customerEntity.setLockTime(null);
                    authenticationRepo.updateCustomer(customerEntity);

                    System.out.println("Account auto-unlocked after 24h for: " + name);
                } else {
                    System.out.println("Account is still locked: " + name);
                    return customerEntity;
                }
            }else {
                return customerEntity;
            }
        }


     if( bCryptPasswordEncoder.matches(password,customerEntity.getPassword()) && customerEntity.getName().equals(name)){
         System.out.println("Password and name are matched");
         customerEntity.setFailedAttempt(0);

         authenticationRepo.updateCustomer(customerEntity);
         return customerEntity;
     }else{
         int attempts = customerEntity.getFailedAttempt()+1;
         customerEntity.setFailedAttempt(attempts);

         if(attempts>=3){
             customerEntity.setAccountLocked(1);
             customerEntity.setLockTime(LocalDateTime.now());
             System.out.println("Account locked due to 3 failed attempts for: " + name);
         } else {
             System.out.println("Invalid password attempt " + attempts + " for: " + name);
         }

         authenticationRepo.updateCustomer(customerEntity);
         return null;
         }
     }




    @Override
    public void updateCustomer(CustomerEntity customerEntity) {
       authenticationRepo.updateCustomer(customerEntity);
    }

    @Override
    public String updatePassword(String email, String password) {

       CustomerEntity customerEntity = authenticationRepo.getByEmail(email);

        if (customerEntity == null) {
            return "No account found with this email.";
        }

        if (customerEntity.getAccountLocked() == 1) {
            LocalDateTime lockTime = customerEntity.getLockTime();
            if (lockTime != null && lockTime.plusHours(24).isAfter(LocalDateTime.now())) {
                return "Your account is locked. Try again after 24 hours.";
            }
        }

        boolean updated = authenticationRepo.updatePassword(email, bCryptPasswordEncoder.encode(password));
        return updated ? "SUCCESS" : "Password update failed. Please try again.";

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
            message.setText(  "Dear User,\n\n"
                    + "Congratulations! Your registration has been completed successfully.\n"
                    + "We are excited to have you as part of the Xworkz community.\n\n"
                    + "You can now log in to your account and explore all the features available to you.\n\n"
                    + "If you have any questions or need support, feel free to reach out to us.\n\n"
                    + "Best Regards,\n"
                    + "Team Xworkz");

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

