package com.finsurge.task44.service;

import com.finsurge.task44.repository.EmailRepository;
import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finsurge.task44.entity.Email;

@Service
public class EmailServiceClass implements EmailService {
    @Autowired
    private EmailRepository emailRepository;

    public void saveEmail(Email email) {
        emailRepository.save(email);
    }
    @Override
    public void sendMail() throws AddressException, MessagingException, IOException,AuthenticationFailedException {
        Email email=emailRepository.getEmail();
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("< ur mail id >", "< ur password >");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("< ur mail id >", false));
        Set<String> to=email.getEmailTo();
        String str1="";
        for(String t:to)
        {
            str1+=t+",";
        }
        System.out.println(str1);
        msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(str1));
        msg.setSubject(email.getEmailSub());
        String content=email.getEmailmsg();
        msg.setContent(content,"text/plain");
        msg.setSentDate(new Date());
        Transport.send(msg);
    }
}

