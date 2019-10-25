package com.practice.coding.common;

import java.util.ArrayList;
import java.util.List;

public class General {
	public static void main(String[] args) {
		int[][] r = new int[5][5];
		List<List<Integer>> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		b.add(1);
		b.add(3);
		b.add(5);
		a.add(b);
		
		int i = 0;
	        r = a.stream().map(  u  ->  u.stream().mapToInt(d->d).toArray()  ).toArray(int[][]::new);
	    System.out.println(r);
	}
}
