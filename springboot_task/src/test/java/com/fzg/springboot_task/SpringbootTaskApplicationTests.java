package com.fzg.springboot_task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {

        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("狗子，你好！");
        mailMessage.setText("好狗");
        mailMessage.setTo("2094698448@qq.com");
        mailMessage.setFrom("1840633803@qq.com");
        mailSender.send(mailMessage);
    }
    @Test
    void contextLoads2() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        //正文
        helper.setSubject("hello,baby~ plus");
        helper.setText("<h1 style='color:blue'>I LOVE YOU!!!</h1>",true);
        //附件
        helper.addAttachment("1.png",new File("C:\\Users\\Admin\\Desktop\\素材文件\\1.png"));
        helper.setTo("1840633803@qq.com");
        helper.setFrom("1840633803@qq.com");
        mailSender.send(mimeMessage);
    }

//    //将发送邮件封装成一个方法
//    public void setMail(Boolean html,String subject,String text,) throws MessagingException {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        //组装
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,html);
//        //正文
//        helper.setSubject(subject);
//        helper.setText(text,true);
//        //附件
//        helper.addAttachment("1.png",new File("C:\\Users\\Admin\\Desktop\\素材文件\\1.png"));
//        helper.setTo("1840633803@qq.com");
//        helper.setFrom("1840633803@qq.com");
//        mailSender.send(mimeMessage);
//    }

}
