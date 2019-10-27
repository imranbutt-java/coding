package com.practice.coding.array;

/**
 *
 * Leetcode: 698. Partition to K Equal Sum Subsets
 Given an array of integers nums and a positive integer k, find whether it's
 possible to divide this array into k non-empty subsets whose sums are all equal.

 Example 1:

 Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 Output: True
 Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 */
public class PartitionKEqualSum {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int num : nums) total += num;
        if(k == 0 || total % k == 1) return false;

        return helper(0, nums, new boolean[nums.length], k,0, total/2);
    }

    private boolean helper(int index, int[] nums, boolean[] seen, int k, int sum, int target) {
        //If we have only one partition
        if(k == 1) return true;
        //when we have achieved one partition, we would request for next one
        if(sum == target)
            return helper(index+1, nums, seen, k-1, sum + nums[index], target);

        for(int n=index; n<nums.length; n++) {
            if(!seen[n]) {
                seen[n] = true;
                if(helper(n, nums, seen, k-1, sum+nums[n], target))
                    return true;
                seen[n] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionKEqualSum c = new PartitionKEqualSum();
        System.out.println("Can Partition: "+c.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }
}
