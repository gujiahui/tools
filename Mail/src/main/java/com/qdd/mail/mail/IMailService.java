package com.qdd.mail.mail;

import javax.mail.MessagingException;

public interface IMailService {
	/**
	 * 发送文本邮件
	 * 
	 * @param to
	 * @param subject
	 * @param content
	 */
	public void sendSimpleMail(String subject, String content);

	public void sendSimpleMail(String subject, String content, String... cc);

	/**
	 * 发送HTML邮件
	 * 
	 * @param to
	 * @param subject
	 * @param content
	 * @throws MessagingException
	 */
	public void sendHtmlMail(String subject, String content) throws MessagingException;


	/**
	 * 发送带附件的邮件
	 * 
	 * @param to
	 * @param subject
	 * @param content
	 * @param filePath
	 * @throws MessagingException
	 */
	public void sendAttachmentsMail(String subject, String content, String filePath) throws MessagingException;


	/**
	 * 发送正文中有静态资源的邮件
	 * 
	 * @param to
	 * @param subject
	 * @param content
	 * @param rscPath
	 * @param rscId
	 * @throws MessagingException
	 */
	public void sendResourceMail(String subject, String content, String rscPath, String rscId)
			throws MessagingException;

}