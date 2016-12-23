package com.devin.java.email;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by devin on 2016/12/23.
 */
public class TestEmail {

    public static void main(String[] args) throws MessagingException {

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.exmail.qq.com");
        sender.setUsername("835804205@qq.com");
        sender.setPassword("EpDc0925");
        Properties prop = new Properties();
        prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.setProperty("mail.smtp.port", "465");
        prop.setProperty("mail.smtp.socketFactory.port", "465");
        sender.setJavaMailProperties(prop);


        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("835804205@qq.com");
        helper.setSubject("Thank you");
        helper.setTo("epdcsiman@163.com");
        helper.setText("Thank you for ordering!");

        sender.send(message);

    }

}
