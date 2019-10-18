package com.practice.coding.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ComposeRanges {
	public static void main(String[] args) {
		ComposeRanges cr = new ComposeRanges();
		int[] nums = {1,3};
		for(String s:cr.composeRanges(nums)) {
			System.out.println(s);
		}
	}
	
	String[] composeRanges(int[] nums) {
	    if(nums.length == 0) return new String[0];
	    List<String> result = new ArrayList<>();

	    if(nums.length == 1)
	        result.add(nums[0]+"");
	    int expectedNextNum = nums[0]+1;
	    String s = null;
	    int ind = 0;
	    for(int i=0; i<nums.length; i++) {

	        if(s == null) {
	            s = nums[i]+"";
	            expectedNextNum = nums[i] + 1;
	        } else if(expectedNextNum == nums[i]) {
	            expectedNextNum = nums[i]+1;
	            if(i== nums.length-1)
	                result.add(s+"->"+nums[i]);
	            ind++;
	        }else if(s != null && expectedNextNum != nums[i] && ind > 0) {
	            result.add(s+"->"+nums[i-1]);
	            s = nums[i]+"";
	            if(i== nums.length-1)
	                result.add(s);

	            expectedNextNum = nums[i]+1;
	            ind = 0;
	        }else if(s!=null && expectedNextNum != nums[i] && ind == 0) {
	             result.add(s);
	             s = nums[i]+"";
	             if(i== nums.length-1)
		                result.add(s);
	             expectedNextNum = nums[i]+1;
	             ind = 0;
	         }
	    }
	    return result.stream().toArray(String[]::new);
	}

}
