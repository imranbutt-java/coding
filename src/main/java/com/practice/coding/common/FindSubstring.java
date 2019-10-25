package com.practice.coding.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindSubstring {
	public static void main(String[] args) {
		String[] words = {"Apple", "Melon", "Orange", "Watermelon"};
		String[] parts = {"a", "mel", "lon", "el", "An"};
		String[] result = findSubstrings(words, parts);
		Arrays.asList(result).stream().forEach(r -> System.out.println(r));
	}
	
	static String[] findSubstrings(String[] words, String[] parts) {
		String[] result = new String[words.length];
	    int i = 0;
	    String finalP = null;
    	int finalI = -1;
    	
	    for(String w: words) {
	    	
	    	finalP = null;
	    	finalI = -1;
	    	
	    	for(String p: parts) {
	    		if(w.contains(p)) {
	    			if(finalP == null 
	    					|| p.length() > finalP.length()  
	    					|| (w.indexOf(p) < finalI && p.length() == finalP.length())) {
	    				finalP = p;
	    				finalI = w.indexOf(p);
	    			}
	    		}
	    	}
	    	result[i] = w;
	    	if(finalP != null) {
    			result[i] = w.replaceFirst(finalP, "["+finalP+"]");
    		}
	    	i++;
	    }
	    	
	    return result;
	}

}
