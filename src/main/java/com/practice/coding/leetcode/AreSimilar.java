package com.practice.coding.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AreSimilar {
	public static void main(String[] args) {
		AreSimilar claz = new AreSimilar();
		int[] a = {2, 1, 3};
		int[] b = {1, 2, 3};
		System.out.println(claz.areSimilar(a, b));
	}

	boolean areSimilar(int[] A, int[] B) {
		List<Integer> ids = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			if ( A[i] != B[i] ) {
				ids.add(i);
			}
		}
		if (ids.size() == 0) {
			return true;
		}
		if (ids.size() != 2) {
			return false;
		}
		int id1 = ids.get(0);
		int id2 = ids.get(1);
		if (A[id1] == B[id2] && A[id2] == B[id1]) {
			return true;
		}
		return false;
	}

}
