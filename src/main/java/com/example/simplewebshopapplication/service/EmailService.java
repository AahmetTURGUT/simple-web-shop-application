package com.example.simplewebshopapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.admin}")
    private String adminMail;

    @Value("${spring.mail.active}")
    private Boolean active;


    public void sendEmailSellProduct(String text) {
        if (active) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(adminMail);
            message.setSubject("Sell Product Info");
            message.setText(text);
            mailSender.send(message);
        }
    }
}