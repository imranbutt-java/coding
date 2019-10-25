package com.practice.coding.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CamelCase {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        List<String> r = new ArrayList<>();
        
        int start = 0;
        int end = 0;
        for(char c: s.toCharArray()) {
            if(Character.isUpperCase(c) && Character.getNumericValue(c)>= 10 && Character.getNumericValue(c) <= 35) {
                r.add(s.substring(start, end));
                start = end;
            }
            end++;
        }
        if(end == s.length()) {
        	r.add(s.substring(start, end));
        }
        for(String p: r) {
            System.out.println(p);
        }
    }
}