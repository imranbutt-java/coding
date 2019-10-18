package com.practice.coding.leetcode;

import java.util.Arrays;

public class AddBorder {
	public static void main(String[] args) {
		AddBorder border = new AddBorder();
		String[] b = {"abc", "def"};
		String[] a = border.addBorder(b);
		for(String s : a) {
			System.out.println(s);
		}
	}
	String[] addBorder(String[] picture) {
	    String[] result = new String[picture.length+2];
	    Arrays.fill(result, "*");
	    int maxLen = picture[0].length();
	    
	    for(int i=0; i<picture.length; i++) {
	        result[i+1] = "*"+picture[i]+"*";
	    }
	    for(int i=0; i<maxLen; i++) {
	        result[0]+="*";
	        result[result.length-1]+="*";
	    }
	    return result;
	}
}
