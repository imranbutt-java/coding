package com.practice.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

	public static void main(String[] args) {

		List<List<Integer>> input = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(1, -1));

		List<List<Integer>> result = closestLocations(3, input, 2);
		System.out.println(result);

	}

	public static List<List<Integer>> closestLocations(int totalCrates, List<List<Integer>> allLocations,
			int truckCapacity) {

		List<List<Integer>> result = null;

		if (truckCapacity <= totalCrates) {
			result = new ArrayList<>();
			Collections.sort(allLocations,
					(listOne, listTwo) -> (int) (Math.sqrt(square(listOne))) - (int) (Math.sqrt(square(listTwo))));
			for (int i = 0; i < truckCapacity; i++) {
				result.add(allLocations.get(i));
			}
		}
		return result;
	}

	private static int square(List<Integer> list){
	  return (list.get(0).intValue() * list.get(0).intValue()) + (list.get(1).intValue() * list.get(1).intValue());
	 }
}