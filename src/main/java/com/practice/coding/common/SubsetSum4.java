package com.practice.coding.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetSum4 {

    private int[] numbers;
    private int sum = 5;
    private int totalSum = 0;
    private ArrayList<ArrayList<Integer>> results;
 
    public SubsetSum4(int[] numbers)
    {
        this.numbers = numbers;
        Arrays.sort(numbers);
        for(int item : numbers) 
            totalSum += item;
    }

    public ArrayList<ArrayList<Integer>> run()
    {
        results = new ArrayList<ArrayList<Integer>>();
        sumOfSubsets(0, 0, totalSum, new ArrayList<Integer>());
        return results;
    }

    private void sumOfSubsets(int index, int currentSum, int remainingSum, ArrayList<Integer> sublist)
    {
        sublist.add(numbers[index]);
        if(numbers[index] + currentSum == sum)
        {
            results.add(sublist);
        }
        else if(index + 1 < numbers.length && currentSum + numbers[index] + numbers[index + 1] <= sum)
        {
            sumOfSubsets(index + 1, currentSum + numbers[index], remainingSum - numbers[index], new ArrayList<Integer>(sublist));
        }
        if(index + 1 < numbers.length && currentSum + numbers [index + 1] <= sum && currentSum + remainingSum - numbers[index] >= sum)
        {
            sublist.remove(sublist.size()-1);
            sumOfSubsets(index + 1, currentSum, remainingSum - numbers[index], new ArrayList<Integer>(sublist));
        }
    }
 
    public static void main(String[] args)
    {
    	int[] numbers  = {};
    	if(numbers.length == 0) System.out.println("Empty");
        
        SubsetSum4 algo = new SubsetSum4(numbers);
        ArrayList<ArrayList<Integer>> results = algo.run();
        Set<List<Integer>> b = new HashSet<>();
        int index = 0;
        for(ArrayList<Integer> a : results) {
        	if(!b.add(a)){
        		results.remove(index);
        	}
        		
        	index++;
            System.out.println(a);
        }
        int[][] r = results.stream().map(u->u.stream().mapToInt(i->i).toArray()).toArray(int[][]::new);
        System.out.println(r);
    }
}