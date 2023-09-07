package com.example.courseapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendEmail {
    @Autowired
    public JavaMailSender emailSender;

    @PostMapping("/send-simple-email")
    public ResponseEntity<?> sendSimpleEmail() {
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("abc@gmail.com");
        message.setSubject("Khanh");
        message.setText("Hello World");

        // Send Message!
        emailSender.send(message);

        return ResponseEntity.ok("Success!!!");
    }
}
