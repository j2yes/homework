package com.wmp.utils.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.wmp.utils.WmpStringUtils;

public class WmpStringUtilsTest {
	
	@Test
	public void testGetOnlyNumberAndAlphabet() {
		String resultValue = WmpStringUtils.getOnlyNumberAndAlphabet("azA%Z091&&*");
        assertEquals("azAZ091", resultValue);
	}
	
	@Test
	public void testFilterAndMixString() {
		String resultValue = WmpStringUtils.filterAndMixString("!#ZA?09aBc1?");	
		// String resultValue = WmpStringUtils.filterAndMixString("1+1ㄱㄴ07z!#*");
        assertEquals("A0a1B9cZ", resultValue);
	}
}
