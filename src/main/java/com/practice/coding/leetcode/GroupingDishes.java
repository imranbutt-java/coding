package com.practice.coding.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class GroupingDishes {

	public static void main(String[] args) {
		
		GroupingDishes g = new GroupingDishes();
		g.makeDishes();
	}
	
	public void makeDishes() {
		String[][] dishes = {{"Salad","Tomato","Cucumber","Salad","Sauce"}, 
			                 {"Pizza","Tomato","Sausage","Sauce","Dough"}, 
			                 {"Quesadilla","Chicken","Cheese","Sauce"}, 
			                 {"Sandwich","Salad","Bread","Tomato","Cheese"}};
		
		String[][] result = groupingDishes(dishes);
		for(String[] dish: result) {
			System.out.println(Arrays.toString(dish));
		}
	}
	
	String[][] groupingDishes(String[][] dishes) {
		Map<String, ArrayList<String>> map = new TreeMap();

		for (String[] l : dishes)
			for (int i = 1; i < l.length; i++) {
				ArrayList<String> cl = new ArrayList();
				if (!map.containsKey(l[i])) {
					cl.add(l[0]);
					map.put(l[i], cl);
				} else {
					map.get(l[i]).add(l[0]);
				}
			}

		for (String[] l : dishes)
			for (int i = 1; i < l.length; i++) {
				if (map.get(l[i]).size() < 2)
					map.remove(l[i]);
				else
					Collections.sort(map.get(l[i]));
			}

		String[][] res = new String[map.size()][];
		int index = 0;
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			entry.getValue().add(0, entry.getKey());
			res[index++] = entry.getValue().toArray(new String[0]);
		}

		return res;
	}

}
