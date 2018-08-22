package com.wmp.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class WmpStringUtils {
	
	public static String getOnlyNumberAndAlphabet(String inputText) {
		char[] charArr = inputText.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(char c : charArr) {
			int code = (int)c;
			if((code > 96 && code < 123) || (code > 64 && code < 91) || (code > 47 && code < 58)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public static String filterAndMixString(String inputText) {
		char[] inputCharArr = inputText.toCharArray();
		List<Integer> alphabetList = new ArrayList<Integer>();
		List<Character> numberList = new ArrayList<Character>();
        StringBuilder sb = new StringBuilder();
		
        // filter number and alphabet
        for(char c : inputCharArr) {
			int code = (int)c;
			if(code > 96 && code < 123) {
				alphabetList.add(2*(code-96));
			} else if(code > 64 && code < 91) {
				alphabetList.add(2*(code-64)-1);
			} else if(code > 47 && code < 58) {
				numberList.add(c);
			}
		}
		
        // sorting
        Collections.sort(alphabetList);
        Collections.sort(numberList);
		
        // mix 
        int alphabetSize = alphabetList.size();
		int numberSize = numberList.size();
		int maxSize = alphabetSize > numberSize ? alphabetSize : numberSize;
		for(int i=0;i<maxSize;i++) {
            if(alphabetSize > i) {
            	int convertedCode = alphabetList.get(i);
            	char c = (char) (convertedCode % 2 == 0 ? (convertedCode/2 + 96) : (convertedCode/2 + 65));
            	sb.append(c);
			}
            if(numberSize > i) {
				sb.append(numberList.get(i));
			}
		}
		return sb.toString();
	}
}
