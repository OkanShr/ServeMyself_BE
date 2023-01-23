package com.okan.ServeMyself_BE.service;

//bound to

import com.okan.ServeMyself_BE.model.Mail;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {


    private final JavaMailSender emailSender;

    public MailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(Mail mailModel) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("okan.shr@hotmail.com");
        message.setTo(mailModel.getTo());
        message.setSubject(mailModel.getSubject());
        message.setText(mailModel.getText());
        emailSender.send(message);
    }

}
