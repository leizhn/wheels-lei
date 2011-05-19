package com.tinfochina.infra.mail.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.autonavi.infra.utils.mail.SimplePlainMailSendee;

public class DefaultSenderTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSend() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tinfochina/infra/mail/impl/*.xml");
		SimplePlainMailSendee sender = ac.getBean("mailSender", SimplePlainMailSendee.class);
		sender.send("hello", "there");
		assertTrue(true);
	}

}
