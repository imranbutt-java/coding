package com.practice.coding.common;

public class ProductOfArrayExceptSelf {
	public static void main(String[] args) {
		ProductOfArrayExceptSelf a = new ProductOfArrayExceptSelf();
		a.solve();
	}
	
	public void solve() {
		int[] nums = {1,2,3,4};
		for(int a :productExceptSelf(nums)) {
			System.out.println(a);
		}
	}
	public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int[] result = new int[n];
        int left = 1;
        
        for(int i = 0; i < nums.length; i++) {          
            if(i > 0) {
                left *= nums[i - 1];
            }
            result[i] = left;
        }
        int right = 1;
        for(int i = n - 1; i >= 0; i--) {
            if(i < n - 1) {
                right *= nums[i + 1];
            }
            result[i] *= right;
        }
        
        return result;
        
    }

}
