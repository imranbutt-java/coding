package com.practice.coding;

public class RotateImage {
	public static void main(String[] args) {
		RotateImage a = new RotateImage();
		a.solve();
	}
	
	public void solve() {
		int[][] nums = {{1,2,3},
						{4,5,6},
						{7,8,9}};
		rotate(nums);
		for(int[] a :nums) {
			for(int b: a) {
				System.out.print(b+", ");
			}
			System.out.println();
		}
	}
	
	public void rotate(int[][] matrix) {
        
        for(int i = 0; i < matrix.length; i++) {           
            for(int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;                
            }
        }
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = temp;
            }
        }
    }

}
