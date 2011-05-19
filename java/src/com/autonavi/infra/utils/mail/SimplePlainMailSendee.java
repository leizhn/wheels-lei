package com.autonavi.infra.utils.mail;

/**
 * 纯文本邮件发送器
 * 
 * @author zhenhua.lei
 * @version 0.1.0.20100715
 */
public interface SimplePlainMailSendee {

	/**
	 * 按给定的主题和正文发送邮件
	 * 
	 * @param subject
	 *            主题
	 * @param body
	 *            正文
	 * @throws MailException
	 */
	void send(String subject, String body) throws MailException;

}