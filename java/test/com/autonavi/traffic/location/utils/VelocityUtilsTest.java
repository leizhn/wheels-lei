package com.autonavi.traffic.location.utils;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final public class VelocityUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testToKmPerHour() {
		double kmPerHour = VelocityUtils.toKmPerHour(255);
		logger.info("{}",kmPerHour);
	}

	@Test
	public final void testToMetersPerSecond() {
		fail("Not yet implemented");
	}

	final static Logger logger = LoggerFactory.getLogger(VelocityUtilsTest.class);
}
