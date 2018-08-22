package com.wmp.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wmp.utils.WmpStringUtils;

@Service
public class StringServiceImpl implements StringService {

	@Override
	public Map<String, Integer> calcString(String inputText, int unit) {
		String resultText = WmpStringUtils.filterAndMixString(inputText);
		int resultTextLength = resultText.length();
		Map<String, Integer> response = new HashMap<String, Integer>();  
		response.put("quotient", resultTextLength / unit);
		response.put("remainder", resultTextLength % unit);
		return response;
	}

}
