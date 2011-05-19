package com.autonavi.infra.utils.sms;

/**
 * @author zhenhua.lei
 * 
 */
public interface ShortMessageSendee {
	/**
	 * @param body
	 * @throws MessageException
	 */
	void send(String body) throws MessageException;
}
