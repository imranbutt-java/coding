package com.practice.coding.common;

public class ReverseParenthesis {
	public static void main(String[] args) {
		ReverseParenthesis s = new ReverseParenthesis();
		System.out.println(s.reverseParentheses("a(b()d)"));
	}
	String reverseParentheses(String s) {
	    int st = s.lastIndexOf('(');
	    while(st != -1) {
	        int ed = s.indexOf(')', st);
	        String t = s.substring(0, st);
	        t += new StringBuffer(s.substring(st + 1, ed)).reverse().toString();
	        t += s.substring(ed + 1);
	        s = t;
	        st = s.lastIndexOf('(');
	    }
	    return s;
	}
}
