package com.finsurge.task44.service;


import jakarta.mail.AuthenticationFailedException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;

import com.finsurge.task44.entity.Email;

import java.io.IOException;

public interface EmailService  {

    public void saveEmail(Email email);
    public void sendMail() throws AddressException, MessagingException, IOException, AuthenticationFailedException;
}

