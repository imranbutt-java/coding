package com.practice.coding.common;

import java.util.Comparator;
import java.util.HashSet;

public class SwapLexOrder {
	public static void main(String[] args) {
		SwapLexOrder order = new SwapLexOrder();
		System.out.println(order.swapLexOrder());
	}
	
	String swapLexOrder() {
		String str = "abdc";
		int[][] pairs = {{1,4}, {3,4}};
		return swapLexOrder(str, pairs);
//		String a = "fixmfbhyutghwbyezkveyameoamqoi";
//		int[][] another = {{8,5}, 
//		                   {10,8}, 
//		                   {4,18}, 
//		                   {20,12}, 
//		                   {5,2}, 
//		                   {17,2}, 
//		                   {13,25}, 
//		                   {29,12}, 
//		                   {22,2}, 
//		                   {17,11}};
//		return swapLexOrder(a, another);
	}
	
	String swapLexOrder(String str, int[][] pairs) {
		HashSet<String> set = new HashSet<>();
		if(pairs == null || pairs.length == 0) return str;
		for (int i = 0; i < pairs.length; i++)
	    {
	        // j is the number of elements which should be printed
	        for (int j = i; j < pairs.length; j++)
	        {
	        	String s = new String(str);
	            // print the array from i to j
//	            for (int k = i; k <= j; k++) {
	            for(int k = i; k <= j; k++) {
	            	s = swapString(s, pairs[k][0]-1, pairs[k][1]-1);
	            	set.add(s);
	            }
	        }
	    }
		return set.stream().sorted(Comparator.reverseOrder()).iterator().next();
	}
	
	String swapString(String s, int a, int b) {
	    char[] charArr = s.toCharArray();
	    char c = s.charAt(a);
	    charArr[a] = s.charAt(b);
	    charArr[b] = c;
	    return new String(charArr);

	}
}
