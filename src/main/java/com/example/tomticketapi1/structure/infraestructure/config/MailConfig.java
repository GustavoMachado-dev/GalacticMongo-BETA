package com.example.tomticketapi1.structure.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * A classe MailConfig configura o envio de e-mails na aplicação.
 * Ela define um bean do tipo JavaMailSender que utiliza o
 * servidor SMTP do Gmail para enviar e-mails.
 */
@Configuration
public class MailConfig {

    /**
     * Cria e configura um bean do tipo JavaMailSender.
     *
     * @return um objeto JavaMailSender configurado para
     * enviar e-mails através do servidor SMTP do Gmail.
     */
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("<your@mail.here>");
        mailSender.setPassword("<your_password_here>");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}