package com.autonavi.infra.utils.mail;

/**
 * ���ı��ʼ�������
 * 
 * @author zhenhua.lei
 * @version 0.1.0.20100715
 */
public interface SimplePlainMailSendee {

	/**
	 * ����������������ķ����ʼ�
	 * 
	 * @param subject
	 *            ����
	 * @param body
	 *            ����
	 * @throws MailException
	 */
	void send(String subject, String body) throws MailException;

}