package com.practice.coding.common;

import java.util.HashSet;

public class PossibleSum {
	
	public static void main(String[] args) {
		PossibleSum ps = new PossibleSum();
		System.out.println(ps.possibleSum());
	}
	
	public int possibleSum() {
		int[] coins = {10, 50, 100};
		int[] quantity = {1, 2, 1};
		return possibleSums2(coins, quantity).size();
	}
	
	
	void solve(int[] coins, int[] quantity, int idx, int sum, HashSet<Integer> sums, int iter){
	    if(idx == coins.length){
	    	System.out.println("Index Now: "+idx+", "+sum);
	        sums.add(sum);
	        return;
	    }
	    
	    for(int i = 0; i <= quantity[idx]; i++) {
	    	System.out.println("Iteration: "+iter+" >>> i: "+i+", idx: "+idx+" [sum + coins[idx] * i]: "+(sum + coins[idx] * i)+", sum: "+sum);
	    	solve(coins, quantity, idx + 1, sum + coins[idx] * i, sums, iter+1);
	    }
	}

	HashSet<Integer> possibleSums2(int[] coins, int[] quantity) {
	    HashSet<Integer> sums = new HashSet<Integer>();
	    solve(coins, quantity, 0, 0, sums, 1);
	    for(Integer i : sums) {
	    	System.out.print(i+" ");
	    }
	    System.out.println();
	    return sums;
	}

}
