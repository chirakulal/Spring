package com.xworkz.customerForm.service;

import com.xworkz.customerForm.dto.CustomerDTO;
import com.xworkz.customerForm.entity.CustomerEntity;
import com.xworkz.customerForm.repository.AuthenticationRepoImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
@Slf4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private static final Logger log = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
    @Autowired
    AuthenticationRepoImpl authenticationRepo;

    private final Map<String, String> otpStorage = new HashMap<>();

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
        customerEntity.setImagePath(customerDTO.getImagePath());

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
                    log.info("Account auto-unlocked after 24h for: " + name);
                } else {
                    log.info("Account still locked for: " + name);
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

                    log.info("Account auto-unlocked after 24h for: " + name);
                } else {
                    log.info("Account is still locked: " + name);
                    return customerEntity;
                }
            }else {
                return customerEntity;
            }
        }


     if( bCryptPasswordEncoder.matches(password,customerEntity.getPassword()) && customerEntity.getName().equals(name)){
         log.info("Password and name are matched");
         customerEntity.setFailedAttempt(0);

         authenticationRepo.updateCustomer(customerEntity);
         return customerEntity;
     }else{
         int attempts = customerEntity.getFailedAttempt()+1;
         customerEntity.setFailedAttempt(attempts);

         if(attempts>=3){
             customerEntity.setAccountLocked(1);
             customerEntity.setLockTime(LocalDateTime.now());
             log.info("Account locked due to 3 failed attempts for: " + name);
         } else {
             log.info("Invalid password attempt " + attempts + " for: " + name);
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



        boolean updated = authenticationRepo.updatePassword(email, bCryptPasswordEncoder.encode(password));
        return updated ? "SUCCESS" : "Password update failed. Please try again.";

    }


    private void sendEmail(String email){
        final String username = "chirashreelk@gmail.com";
        final String password = "wvxi xvhj jfcr bgkh";

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
    public CustomerDTO getByEmail(String email) {

        CustomerEntity customerEntity = authenticationRepo.getByEmail(email);
        CustomerDTO customerDTO =new CustomerDTO();
        customerDTO.setEmail(customerEntity.getEmail());
        customerDTO.setGender(customerEntity.getGender());
        customerDTO.setAge(customerEntity.getAge());
        customerDTO.setAddress(customerEntity.getAddress());
        customerDTO.setPassword(customerEntity.getPassword());
        customerDTO.setName(customerEntity.getName());
        customerDTO.setPhoneNumber(customerEntity.getPhoneNumber());
        customerDTO.setImagePath(customerEntity.getImagePath());
        if (customerEntity.getEmail() == null) {
            return null;
        }
        if (customerEntity.getEmail().equals(email)) {
            log.info("email is matched");
            return customerDTO;
        } else  {
            log.info("email does not exist");
            return null;
        }
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
        log.info("Customer DTO: {}", customerDTO);

        return  authenticationRepo.update(customerEntity);
    }

    @Override
    public void sendOtp(String email) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            builder.append(random.nextInt(10));
        }
        String generatedOtp = builder.toString();

        // Save OTP against the email
        otpStorage.put(email, generatedOtp);

        // Send email
        getEmail(email, "OTP Sent",
                "Dear User,\nYour OTP is: " + generatedOtp + "\nIt will expire in 5 minutes.");
    }

    @Override
    public boolean verifyOtp(String email, String otp) {
        // Get OTP stored for this email
        String storedOtp = otpStorage.get(email);
        return otp.equals(storedOtp);
    }

    private void getEmail(String email, String subject, String body) {
        final String username = "chirashreelk@gmail.com";
        final String password = "wvxi xvhj jfcr bgkh";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("chirashreelk@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println(" OTP sent to " + email);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int emailCount(String email) {
        return Math.toIntExact(authenticationRepo.emailCount(email));
    }

    @Override
    public int phoneNumberCount(long phoneNumber) {
        return Math.toIntExact(authenticationRepo.countPhoneNumber(phoneNumber));
    }

    @Override
    public int nameCount(String name) {
        return Math.toIntExact(authenticationRepo.countName(name));
    }

//    @Override
//    public void setProfile(String imagepath) {
//         CustomerEntity customerEntity = new CustomerEntity();
//         customerEntity.setImage(imagepath);
//        authenticationRepo.save(customerEntity);
//    }
}

