package com.practice.coding.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

public class ClimbingStaircase {
	
	public static void main(String[] args) {
		ClimbingStaircase c = new ClimbingStaircase();
		c.solve();
	}
	
	public void solve() {
		climbingStaircase(4, 2);
	}
	
	int[][] climbingStaircase(int n, int k) {
	    if(n <= 0)
	        return new int[1][1];
	    
	    ArrayList<Integer> steps = new ArrayList<Integer>();
	    
	    for(int l=1; l<=k; l++)
	    	steps.add(l);
	    
	    ArrayList<Integer> currentList = new ArrayList<Integer>();
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    climbStairsCombination(steps, n, currentList, result);
	    int[][] r = result.stream().map(  u  ->  u.stream().mapToInt(d->d).toArray()  ).toArray(int[][]::new);
	    return r;
	}

	public static void climbStairsCombination(ArrayList<Integer> steps, int remainingStairs, ArrayList<Integer> currentList, ArrayList<ArrayList<Integer>> result){// a is number of steps
	    if(remainingStairs == 0){
	        ArrayList<Integer> temp = new ArrayList<Integer>(currentList);
	        result.add(temp);
	        return;
	    }
	    for(int i = 0; i < steps.size(); i++){
	        if(remainingStairs < steps.get(i))
	            return;
	        currentList.add(steps.get(i));
	        climbStairsCombination(steps, remainingStairs - steps.get(i), currentList, result);
	        currentList.remove(currentList.size() - 1);
	    }

	}

}
