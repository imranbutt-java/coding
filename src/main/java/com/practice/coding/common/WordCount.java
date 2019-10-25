package com.practice.coding.common;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCount {
	public static void main(String[] args) {
		WordCount wc = new WordCount();
		wc.wordCount(Arrays.asList("ab", "bc", "ab", "c", "c"));
	}
	
	public int wordCount(List<String> text) {
		int result = 0;
		Map<String, Integer> counts = text.stream().
	            collect(Collectors.toConcurrentMap(
	                w -> w, w -> 1, Integer::sum));
	        System.out.println(counts);
		
	        Map<String, Integer> collect = text.stream().collect(Collectors.groupingBy(w->w , 
	        													 Collectors.summingInt(e -> 1)));
	        
	        System.out.println(collect);
	    
		return result;
	}
}
