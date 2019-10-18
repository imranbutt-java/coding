package com.practice.coding.leetcode;

public class FarmLandCell {
	public static void main(String[] args) {
		FarmLandCell f = new FarmLandCell();
		f.numberOfHours();
	}
	
	public void numberOfHours() {
		char[][] c = {{'W', 'E', 'E'},
					  {'E', '#', 'E'},
					  {'E', 'E', 'E'}};
		System.out.println("Wrong Answer: "+numberOfHours(c));
	}
	
	public int numberOfHours(char[][] mat) {
		int result = 0;
		boolean isAvailable = true;
		while(isAvailable) {
			for(int i=0; i<mat.length; i++) {
				for(int j=0; j<mat[i].length; j++) {
					if(mat[i][j] == 'W') {
						//Look Bottom
						if((i-1) != -1 && mat[i-1][j] == 'E') {
							mat[i-1][j] = 'W';
						}//Look Left
						if((j-1) != -1 && mat[i][j-1] == 'E') {
							mat[i][j-1] = 'W';
						}//Look Top
						if((i+1) < mat.length && mat[i+1][j] == 'E') {
							mat[i+1][j] = 'W';
						}//Look Right
						if((j+1) < mat[i].length && mat[i][j+1] == 'E') {
							mat[i][j+1] = 'W';
						}
					}
				}
				
				
				for(int x=0; x<mat.length; x++) {
					for(int y=0; y<mat[x].length; y++) {
						if(mat[x][y] == 'E') {
							isAvailable = true;
							break;
						} else {
							isAvailable = false;
						}
					}
					if(isAvailable) break;
				}
			}
			result++;
		}
		
		return result;
	}
}
