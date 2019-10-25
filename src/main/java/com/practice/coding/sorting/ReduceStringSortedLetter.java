package com.practice.coding.sorting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string return a reduced string such that , the reduced string has the characters re-arranged

in order of characters having highest frequencey
followed by character which appears just once in the same order as in the original string
and no duplicate characters
Example:

Input: "hello world"
Output: "lohe wrd"
Explaination: 'l' appears thrice, 'o' appears twice, 'h','e', ' '(space) ,'w','r','d' all appear once 
'h','e',' ','w','r','d' should be appended in the same order as they appear in the original string  hello world
 * @author imransarwar
 *
 */
public class ReduceStringSortedLetter {
	public static void main(String[] args) {
        System.out.println(reduce("hello world"));
    }
    public static String reduce(String s){
        
        //STEP 1: Create a count, make sure to use a Map that keeps order of insertion, like Linked HashMap
        Map<Character, Integer> count = new LinkedHashMap<>(); 
        for(char c: s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0)+1);
        }
        
        
        //STEP 2: create another map, for each count, create a string builder, based on the previous map (that is in order)
        Map<Integer,StringBuilder> map = new HashMap<>();
        int max = 0;
        for(Map.Entry<Character, Integer> e: count.entrySet()){
            StringBuilder str = map.getOrDefault(e.getValue(), new StringBuilder());
            str.append(e.getKey());
            map.put(e.getValue(), str);
            max = Math.max(max, e.getValue());
        }
     
        //Step 3: just go from max to 1 and append to a result.
        StringBuilder sb = new StringBuilder();
        while(max > 0) sb.append(map.get(max--));
        
        return sb.toString();
    }
}
