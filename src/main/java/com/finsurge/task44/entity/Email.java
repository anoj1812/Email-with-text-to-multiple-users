package com.finsurge.task44.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private Set<String> emailTo;
    private String emailSub;
    private String emailmsg;
    public Set<String> getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(Set<String> emailTo) {
        this.emailTo = emailTo;
    }

    public String getEmailSub() {
        return emailSub;
    }

    public void setEmailSub(String emailSub) {
        this.emailSub = emailSub;
    }

    public String getEmailmsg() {
        return emailmsg;
    }

    public void setEmailmsg(String emailmsg) {
        this.emailmsg = emailmsg;
    }
}

