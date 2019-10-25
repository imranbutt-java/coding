package com.practice.coding.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subset {
	public static void main(String[] args) {
		Subset a = new Subset();
		a.solve();
	}
	
	public void solve() {
		int[] nums = {1,2,3};
		for(List<Integer> a :subsets(nums)) {
			for(Integer b: a) {
				System.out.print(b+", ");
			}
			System.out.println();
		}
	}
	public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        recurse(result, nums, new Stack<>(), 0);
        return result;
    }
    
    
    private void recurse(List<List<Integer>> result, int[] nums, Stack<Integer> path, int position) {
        
        if(position == nums.length) {
            result.add(new ArrayList<>(path));
            return;      
        }
        path.push(nums[position]);
        recurse(result, nums, path, position + 1);
        path.pop();
        recurse(result, nums, path, position + 1);
        
    }
   
}
