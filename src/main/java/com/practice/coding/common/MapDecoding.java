package com.practice.coding.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MapDecoding {
	
	List<Character> charList = new ArrayList<>();
	Set<String> result = new HashSet<>();
	int finalResult = 0;
	
	public static void main(String[] args) {
		MapDecoding mD = new MapDecoding();
		
		System.out.println(mD.decode("121"));
	}
	
	public int decode(String message) {
		if(message == null || message.length() == 0 || message.length() == 1)
			return 1;
		
		int len = message.length();
		int count = 0;
		if(message.charAt(len - 1) > '0')
			count = decode(message.substring(0, len-1));
		if(message.charAt(len-2) == '1' ||  message.charAt(len-2) == '2' && message.charAt(len-1) <= '6')
			count += decode(message.substring(0, len-2));
		
		return count;
	}
}
