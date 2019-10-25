package com.practice.coding.common;

import java.util.HashMap;
import java.util.Map;

public class LongestPath {
	public static void main(String[] args) {
		System.out.println(longestPath("a\r\tbb\r\t\tc.txt"));
	}

	static int longestPath(String fileSystem) {
		int res = 0;
		Map<Integer, Integer> m = new HashMap<>();
		m.put(0, 0);
		for (String s : fileSystem.split("\r")) {
			System.out.println("s: "+s);
			
			int level = s.lastIndexOf("\t") + 1;
			System.out.println("level: "+level);
			
			int len = s.substring(level).length();
			System.out.println("len: "+len);
			
			if (s.contains(".")) {
				res = Math.max(res, m.get(level) + len);
			} else {
				m.put(level + 1, m.get(level) + len + 1);
			}
		}
		return res;
	}
}
