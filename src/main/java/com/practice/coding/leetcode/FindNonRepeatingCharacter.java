package com.practice.coding.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindNonRepeatingCharacter {
	public static void main(String[] args) {
		System.out.println(firstNotRepeatingCharacter("abacabad"));
	}

	static char firstNotRepeatingCharacter(String s) {
		Map<Character, Integer> counts = new LinkedHashMap<>(s.length());

		for (char c : s.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}

		for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return '_';

	}

}
