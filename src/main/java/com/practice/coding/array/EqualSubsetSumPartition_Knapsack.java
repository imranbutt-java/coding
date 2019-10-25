package com.practice.coding.array;

/**
 * Given a set of positive numbers, find if we can partition it into two subsets such that the sum
 * of elements in both the subsets is equal.
 *
 * Example 1:
 * Input: {1, 2, 3, 4}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
 * Example 2:
 * Input: {1, 1, 3, 4, 7}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 3, 4} & {1, 7}
 * Example 3:
 * Input: {2, 3, 4, 6}
 * Output: False
 * Explanation: The given set cannot be partitioned into two subsets with equal sum.
 */
public class EqualSubsetSumPartition_Knapsack {

    boolean canPartition(int[] num) {
        int total = 0;
        //Get some of all numbers
        for(int i: num) total += i;
        //Check if sum is odd return false
        if(total % 2 == 1) return false;
        return helper(num.length - 1, num, 0, total/2);
    }

    private boolean helper(int index, int[] nums, int sum, int target) {
        if(index < 0 || sum > target) return false;
        if(nums[index] > target) return false;
        if(sum == target) return true;
        return helper(index-1, nums, sum + nums[index], target) ||
                helper(index-1, nums, sum, target);

    }

    public static void main(String[] args) {
        EqualSubsetSumPartition_Knapsack c = new EqualSubsetSumPartition_Knapsack();
        System.out.println("Can Partition: "+c.canPartition(new int[]{3,2,3,4}));
    }
}
