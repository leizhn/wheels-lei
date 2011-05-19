package com.autonavi.infra.utils.mail.impl;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autonavi.infra.utils.mail.MailException;
import com.autonavi.infra.utils.mail.SimplePlainMailSendee;

/**
 * 
 * ���ı��ʼ����Ϳͻ���ʵ�֣�ʹ��SSL���ʼ�����������GMail
 * 
 * @author leizhn
 * 
 */
public class SslSender implements SimplePlainMailSendee {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tinfochina.infra.mail.SimplePlainMailSendee#send(java.lang.String,
	 * java.lang.String)
	 */
	public void send(String subject, String body) {
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", smtpHost);
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", String.valueOf(port));
		props.setProperty("mail.smtp.socketFactory.port", String.valueOf(port));
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
		Message msg = new MimeMessage(session);

		try {
			msg.setFrom(new InternetAddress(username));
			msg.setSubject(subject);
			msg.setText(body);
			msg.setSentDate(new Date());
			msg.addRecipients(Message.RecipientType.TO,
					InternetAddress.parse(adddressList));
			Transport.send(msg);
		} catch (AddressException e) {
			logger.debug(e.toString(), e);
			throw new MailException("address unformatted", e);
		} catch (MessagingException e) {
			logger.debug(e.toString(), e);
			throw new MailException("message inform...", e);
		}
	}

	/**
	 * ���÷������б�
	 * 
	 * @param adddressList
	 *            �������б�
	 */
	public void setAdddressList(String adddressList) {
		this.adddressList = adddressList;
	}

	/**
	 * ����ʹ���ʼ����������˻�����Ӧ������
	 * 
	 * @param password
	 *            �˻�����Ӧ������
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * �����ʼ��������˿�
	 * 
	 * @param port
	 *            �ʼ��������˿�
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * ���÷���������������ַ
	 * 
	 * @param smtpHost
	 *            ����������������ַ
	 */
	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	/**
	 * ����ʹ���ʼ����������˻���
	 * 
	 * @param username
	 *            �˻���
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	private String adddressList;

	private String password;

	private int port;

	private String smtpHost;

	private String username;
}
