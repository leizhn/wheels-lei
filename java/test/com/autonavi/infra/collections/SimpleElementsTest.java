package com.autonavi.infra.collections;

import org.junit.Test;


public class SimpleElementsTest {
	@Test(expected=UnsupportedOperationException.class)
	public void testBuild(){
		SimpleElements.Builder<String, String> builder = new SimpleElements.Builder<String, String>();
		builder.put("a", "b");
		builder.build();
		builder.put("a", "b");
	}
}
