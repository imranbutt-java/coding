package com.practice.coding.leetcode;

public class RotateImage {
	public static void main(String[] args) {
		int[][] a = {{1,2,3},
					 {4,5,6},
					 {7,8,9}};
		System.out.println(rotateImage(a));
	}
	
	static int[][] rotateImage(int[][] a) {
	    int aSize = a.length;
	    for (int x = 0; x < (aSize-1) / 2; x++)
	    {
	        for (int y = x; y < aSize-x-1; y++)
	        {
	            // save in temp to replace at the end
	            int temp = a[x][y];

	            a[x][y] = a[aSize-1-y][x];
	            a[aSize-1-x][y] = a[aSize-1-x][aSize-1-y];
	            a[aSize-1-x][aSize-1-y] = a[x][aSize-1-y];
	            a[x][aSize-1-y] = temp;
	        }
	    }
	    
	    return a;
	}

}
