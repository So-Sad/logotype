package com.softarex.app.logotype.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendSignUpEmail(String email){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);

        mailMessage.setSubject("Logotype registration");
        mailMessage.setText("You have just successfully registered at Logotype");

        javaMailSender.send(mailMessage);
    }

    public void sendChangePasswordEmail(String email){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);

        mailMessage.setSubject("Logotype password changes");
        mailMessage.setText("You have just successfully change your password at Logotype");

        javaMailSender.send(mailMessage);
    }

}
