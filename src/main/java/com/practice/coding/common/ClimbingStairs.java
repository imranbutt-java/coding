package com.practice.coding.common;

public class ClimbingStairs {
	
	public static void main(String[] args) {
		ClimbingStairs c = new ClimbingStairs();
		c.solve();
	}
	
	public void solve() {
		System.out.println(climbingStairs(4));
	}
	
	//Fibonacci Series
	int climbingStairs(int n) {
	    if (n <= 2)
	        return n;
	    int[] arr = new int[n+1];
	    arr[0] = 0;
	    arr[1] = 1;
	    arr[2] = 2;
	    for (int i = 3; i <= n; i++) {
	        arr[i] = arr[i-1] + arr[i-2];
	    }
	    return arr[n];
	}
}
