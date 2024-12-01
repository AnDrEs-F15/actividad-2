package com.trad.trad.domain.services.Interfaz;

public interface ITradSendMail {
    public void sendEmail(String to, String subject,String content);
}
