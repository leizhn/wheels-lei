package com.autonavi.infra.utils;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NumbersTest {

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
	public final void testToBinaryString() {
		byte b = Byte.MIN_VALUE;
		int count = 0;
		while(true){
			Assert.assertEquals(8, Numbers.toBinaryString(b).length());
			count++;
			b++;
			if(b==Byte.MAX_VALUE){
				Assert.assertEquals(8, Numbers.toBinaryString(b).length());
				count++;
				break;
			}
		}
		Assert.assertEquals(Math.round(Math.pow(2, 8)), count);
	}
	
	public final void testToHexString(){
		byte b = Byte.MIN_VALUE;
		int count = 0;
		while(true){
			Assert.assertEquals(2, Numbers.toHexString(b).length());
			count++;
			b++;
			if(b==Byte.MAX_VALUE){
				Assert.assertEquals(2, Numbers.toHexString(b).length());
				count++;
				break;
			}
		}
		Assert.assertEquals(Math.round(Math.pow(2, 8)), count);
	}
	
	@Test
	public final void testToBinaryStringList() {
		byte[] input = new byte[4];
		Assert.assertEquals(input.length,Numbers.toBinaryString(input).size());
	}

}
