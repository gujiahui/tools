package com.qdd.mail.mail.impl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.qdd.mail.mail.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;



@Component
public class IMailServiceImpl implements IMailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.from}")
    private String from;
    @Value(value="${jolo.mail.address.to}")
    private String mailTo;
    
   

	/**
     * 发送文本邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    @Override
    public void sendSimpleMail( String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(mailTo.split(","));
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }

    @Override
    public void sendSimpleMail( String subject, String content, String... cc) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(mailTo.split(","));
        message.setCc(cc);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }

    /**
     * 发送HTML邮件
     * @param to
     * @param subject
     * @param content
     */
    @Override
    public void sendHtmlMail(String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        //true表示需要创建一个multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(mailTo.split(","));
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     */
    @Override
    public void sendAttachmentsMail(String subject, String content, String filePath) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(mailTo.split(","));
        helper.setSubject(subject);
        helper.setText(content, true);

        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
        helper.addAttachment(fileName, file);

        mailSender.send(message);
    }


    /**
     * 发送正文中有静态资源（图片）的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     */
    @Override
    public void sendResourceMail(String subject, String content, String rscPath, String rscId) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(mailTo.split(","));
        helper.setSubject(subject);
        helper.setText(content, true);

        FileSystemResource res = new FileSystemResource(new File(rscPath));
        helper.addInline(rscId, res);

        mailSender.send(message);
    }

} 