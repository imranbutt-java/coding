package com.practice.coding.common;

import java.util.HashSet;

public class Sudoku2 {
	public static void main(String args[]) {
		Sudoku2 s = new Sudoku2();
		char[][] input = new char[9][9];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                input[i][j] = '.';
            }
        }

        input[0] = "..9748...".toCharArray();
        input[1] = "7........".toCharArray();
        input[2] = ".2.1.9...".toCharArray();
        input[3] = "..7...24.".toCharArray();
        input[4] = ".64.1.59.".toCharArray();
        input[5] = ".98...3..".toCharArray();
        input[6] = "...8.3.2.".toCharArray();
        input[7] = "........6".toCharArray();
        input[8] = "...2759..".toCharArray();
        System.out.println(s.sudoku2(input));
	}
	
	boolean sudoku2(char[][] grid) {
	    HashSet<Character> set, set2;
	    for (int i = 0; i < 9; i++) {
	        set = new HashSet<>();
	        set2 = new HashSet<>();
	        for (int j = 0; j < 9; j++) {
	            if(!set.add(grid[i][j]) && grid[i][j] != '.') return false;
	            if(!set2.add(grid[j][i]) && grid[j][i] != '.') return false;
	        }
	    }
	    // checking 9 boxes
	    for (int x = 0; x < 9; x += 3) {
	        for (int y = 0; y < 9; y += 3) {
	            set = new HashSet<>();
	            for (int i = x; i < x + 3; i++) {
	                for (int j = y; j < y + 3; j++) {
	                    if(!set.add(grid[i][j]) && grid[i][j] != '.')
	                        return false;
	                }
	            }
	        }
	    }
	    return true;
	}

}
