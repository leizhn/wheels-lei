package com.tinfochina.infra.volume;

import junit.framework.Assert;

import org.junit.Test;

public class SortDirTest {
	@Test
	public void testEqualsObject() {
		boolean result = SortDir.ASC.equals(SortDir.instance(0));
		Assert.assertTrue(result);
		result = SortDir.DESC.equals(SortDir.instance(1));
		Assert.assertTrue(result);
		result = SortDir.DESC.equals(SortDir.instance(0));
		Assert.assertFalse(result);
	}

	@Test
	public void testHashCode() {
		boolean result = SortDir.ASC.hashCode() == SortDir.DESC.hashCode();
		Assert.assertFalse(result);
	}

	@Test
	public void testInstanceInt() {
		Assert.assertEquals(SortDir.ASC, SortDir.instance(0));
		Assert.assertEquals(SortDir.DESC, SortDir.instance(-1));
		Assert.assertEquals(SortDir.DESC, SortDir.instance(100));
		Assert.assertEquals(SortDir.DESC, SortDir.instance(-4255));
	}

	@Test
	public void testInstanceString() {
		Assert.assertEquals(SortDir.ASC, SortDir.instance("asc"));
		Assert.assertEquals(SortDir.ASC, SortDir.instance("ASC"));
		Assert.assertEquals(SortDir.ASC, SortDir.instance("leilaohu"));
		Assert.assertEquals(SortDir.DESC, SortDir.instance("DESC"));
		Assert.assertEquals(SortDir.DESC, SortDir.instance("desc"));
		Assert.assertEquals(SortDir.DESC, SortDir.instance("descend"));
		Assert.assertEquals(SortDir.DESC, SortDir.instance("DESCEND"));
	}

}
