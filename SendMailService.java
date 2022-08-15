package com.axelbork.portfolio.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String name, String email, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("axelbork@gmail.com");
        mailMessage.setTo("axelbork@gmail.com");
        mailMessage.setText("Email: " + email + "\n \n" + "Consulta: " + message);
        mailMessage.setSubject("Consulta realizada desde el Portfolio de: " + name);

        javaMailSender.send(mailMessage);

        System.out.println("Mail enviado");
    }
}
