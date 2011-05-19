package com.autonavi.infra.concurrent;

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonThreadFactoryTest {

	@Test
	public void testNewThread() {
		String poolName = "test";
		CommonThreadFactory ctf = new CommonThreadFactory(poolName);

		Thread newThread = ctf.newThread(new Runnabled());
		Assert.assertTrue(newThread.getName().startsWith(poolName));
		Assert.assertTrue(newThread.getName().endsWith("1"));
		logger.info(newThread.getName());

		newThread = ctf.newThread(new Runnabled());
		Assert.assertTrue(newThread.getName().startsWith(poolName));
		Assert.assertTrue(newThread.getName().endsWith("2"));
		logger.info(newThread.getName());

		ctf = new CommonThreadFactory(poolName);

		newThread = ctf.newThread(new Runnabled());
		Assert.assertTrue(newThread.getName().startsWith(poolName));
		Assert.assertTrue(newThread.getName().endsWith("1"));
		logger.info(newThread.getName());
	}

	final static Logger logger = LoggerFactory
			.getLogger(CommonThreadFactoryTest.class);

	private static final class Runnabled implements Runnable {
		@Override
		public void run() {
		}
	}
}
