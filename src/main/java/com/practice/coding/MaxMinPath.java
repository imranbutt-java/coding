package com.practice.coding;

/*
To a mat [] [] of the matirx, for a from the top left to the bottom of the path pi, pi the minimum is mi, find all mi in the maximum. Only down or right.
such as:
[8, 4, 7]
[6, 5, 9]
There are three paths:
8-4-7-9 min: 4
8-4-5-9 min: 4
8-6-5-9 min: 5
return: 5
*/

public class MaxMinPath {
	
	private int min, max, row, col;
	
	public static void main(String[] args) {
		MaxMinPath a = new MaxMinPath();
		a.solve();
	}
	
	public void solve() {
		int[][] nums = {{8,4,7,3},
					  	{6,5,9,2}};
		System.out.println(maxMinPath(nums));
	}
	
    public int maxMinPath(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfsHelper(matrix, min, 0, 0, "");
        System.out.println("Result from DP: "+maxMinPathDP(matrix));
     return max;
    }

    public void dfsHelper(int[][] matrix, int min, int i, int j, String p ){                
        if (i >= row || j >= col)
        	return;
        
        if (i == row - 1 && j == col - 1) {
        	System.out.println(p+" -> "+matrix[i][j]);
        	
            min = Math.min(min, matrix[i][j]);
            max = Math.max(max, min);
            
            return;
        }
        
        min = Math.min(min, matrix[i][j]);
        p = p +" -> "+matrix[i][j];
        
        dfsHelper(matrix, min, i, j + 1, p);
        dfsHelper(matrix, min, i + 1, j, p);
    }
    
    public int maxMinPathDP(int[][] matrix) {
    	int[] result = new int[matrix[0].length];
    	result[0] = matrix[0][0];
    	
    	for(int i=1; i<matrix[0].length; i++)
    		result[i] = Math.min(result[i-1], matrix[0][i]);
    	
    	for(int i=1; i<matrix.length; i++) {
    		result[0] = Math.min(result[0], matrix[i][0]);
    		for(int j=1; j<matrix[i].length; j++) {
    			result[j] = result[j] < matrix[i][j] && result[j-1] < matrix[i][j] ? 
    						Math.max(result[j-1], result[j]) :
    						matrix[i][j];
    		}
    	}
    	return result[result.length-1];
    }
}
