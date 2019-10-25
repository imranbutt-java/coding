package com.practice.coding.common;

import java.util.Arrays;

public class IsCryptSolution {
	public static void main(String[] args) {
		String[] crypt= {"SEND", "MORE", "MONEY"};
		char[][] solution = {{'O','0'}, 
							   {'M','1'}, 
							   {'Y','2'}, 
							   {'E','5'}, 
							   {'N','6'}, 
							   {'D','7'}, 
							   {'R','8'}, 
							   {'S','9'}};
		System.out.println(isCryptSolution2(crypt, solution));
		
		String[] crypt2= {"AAAAAAAAAAAAAA", "BBBBBBBBBBBBBB", "CCCCCCCCCCCCCC"};
		char[][] solution2 = {{'A','1'},  {'B','2'}, {'C','3'}};
		
		System.out.println(isCryptSolution(crypt2, solution2));
		
		String[] crypt3 = {"WASD", 
		        "IJKL", 
		        "AOPAS"};
		char[][] solution3 = {{'W','2'}, 
		        {'A','0'}, 
		        {'S','4'}, 
		        {'D','1'}, 
		        {'I','5'}, 
		        {'J','8'}, 
		        {'K','6'}, 
		        {'L','3'}, 
		        {'O','7'}, 
		        {'P','9'}};
	
		
		System.out.println(isCryptSolution(crypt3, solution3));
	}
	
	static boolean isCryptSolution(String[] crypt, char[][] solution) {
		String[] result = new String[crypt.length];
		String num = "";
		int count = 0;
		for (String s : crypt) {
			int n = 1;
			for (char c : s.toCharArray()) {

				for (int i = 0; i < solution.length; i++) {
					for (int j = 0; j < 1; j++) {

						if (solution[i][j] == c) {
							if (n == 1) {
								num = ""+solution[i][j+1];
								n++;
							} else {
								
								num = num + solution[i][j+1];
							}

						}
					}
				}
			}
			result[count++] = num;
		}
		if(result[2].charAt(0) == '0' || result[0].length() != 1 && result[0].charAt(0) == '0' || result[1].length() != 1  && result[1].charAt(0) == '0') {
			return false;
		}
		return (Double.parseDouble(result[0]) + Double.parseDouble(result[1]) == Double.parseDouble(result[2]));
	}
	
	static boolean isCryptSolution2(String[] crypt, char[][] solution) {
	    for(char[] arr : solution){
	        for(int i = 0; i < crypt.length; i++){
	            crypt[i]=crypt[i].replace(arr[0],arr[1]);
	        }
	        System.out.println(Arrays.toString(crypt));
	    }
	    
	    for(int i = 0; i < crypt.length; i++){
	        if(!crypt[i].equals("0")&&crypt[i].startsWith("0"))
	            return false;
	    }
	    
	    return Long.parseLong(crypt[0])+Long.parseLong(crypt[1])==Long.parseLong(crypt[2]);
	}

}
