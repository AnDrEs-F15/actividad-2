package com.trad.trad.domain.services.Implementation;

import com.trad.trad.domain.exception.TradAppException;
import com.trad.trad.domain.services.Interfaz.ITradSendMail;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService implements ITradSendMail {
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void sendEmail(String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to); mailMessage.setSubject(subject); mailMessage.setText(content);
        try {
            mailSender.send(mailMessage);
        }catch (MailException e){
            throw new TradAppException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
