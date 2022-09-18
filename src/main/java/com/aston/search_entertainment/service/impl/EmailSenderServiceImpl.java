package com.aston.search_entertainment.service.impl;


import com.aston.search_entertainment.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {

    private JavaMailSender mailSender;


    @Value("${spring.mail.username}")
    private String USERNAME;

    @Override
    public void send(String to, String subject, String text) {
        log.info("Отправка сообщения пользователю: {}", to);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(USERNAME);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        mailSender.send(mailMessage);
        log.info("Сообщение пользователю: {} отправлено", to);
    }
}
