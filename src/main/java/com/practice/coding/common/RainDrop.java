package com.practice.coding.common;

public class RainDrop {
	public static void main(String[] args) {
		RainDrop a = new RainDrop();
		a.solve();
	}
	
	/*
	 *  |**|
	 *  |**|
	 *  ||||
	 *  3113
	 */
	public void solve() {
		int[] nums = {3,1,1,3};
		System.out.println(trap(nums));
	}
	
	public int trap(int[] height) {    
        int water = 0;
        
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        
        int leftMax = 0;
        int rightMax = 0;
        
        while(leftIndex <= rightIndex) {
            leftMax = Math.max(leftMax, height[leftIndex]);
            rightMax = Math.max(rightMax, height[rightIndex]);
            
            if(leftMax < rightMax) {
                water += leftMax - height[leftIndex];
                leftIndex++;
            } else {  
                water += rightMax - height[rightIndex];
                rightIndex--;
            }
        }
        
        return water;
    }
    
}