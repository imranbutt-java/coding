package com.practice.coding;

public class MinimumDiffOfSubSets {
	public int minPartition(int subset[], int n, int sum1, int sum2) {
		if(n<0)
			return Math.abs(sum1-sum2);
		
		int include = minPartition(subset, n-1, sum1+subset[n], sum2);
		int exclude = minPartition(subset, n-1, sum1, sum2+subset[n]);
		
		return Math.min(include, exclude);
	}
	
	public static void main(String[] args) {
		MinimumDiffOfSubSets m = new MinimumDiffOfSubSets();
		m.solve();
	}
	
	public void solve() {
		int[] a = {2, 3, 1, 3, 2};
		System.out.println(minPartition(a, a.length -1, 0, 0));
	}
}
