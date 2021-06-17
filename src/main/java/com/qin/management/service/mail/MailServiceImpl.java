package com.qin.management.service.mail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService{
    @Autowired
    private JavaMailSender mailSender;

    //邮件发件人
    @Value("${spring.mail.username}")
    private String from;
    /**
     * @param to 接收者
     * @param subject 主题
     * @param content 内容
     * @Value注解读取配置文件中同名的配置值
     */

        @Override

        public void sendMail(String to, String subject, String content) {
            SimpleMailMessage message = new SimpleMailMessage();
            //赋予相应的内容
            message.setTo(to);
            message.setSubject(subject);
            message.setText(content);
            message.setFrom(from);
            //将邮件对象赋予邮件发送器
            mailSender.send(message);
        }

}
