package com.wmp.services.test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wmp.services.StringService;
import com.wmp.services.StringServiceImpl;

import com.wmp.services.test.StringServiceTest.StringServiceTestConfig;;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
  StringServiceTestConfig.class
})
public class StringServiceTest {
	
	@PropertySource("classpath:application.properties")
    public static class StringServiceTestConfig {
        @Bean
        public StringService service() {
            return new StringServiceImpl();
        }
    }
	
	@Autowired
	private StringService stringService;
	
	@Test
    public void testCalcString() {
		Map<String, Integer> resultMap = stringService.calcString("!#ZA?09aBc1?", 2);
		
		int quotient = resultMap.get("quotient");
		assertEquals(4, quotient);
		
		int remainder = resultMap.get("remainder");
        assertEquals(0, remainder);
    }
	
}
