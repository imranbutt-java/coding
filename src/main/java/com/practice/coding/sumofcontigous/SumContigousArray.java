package com.practice.coding.sumofcontigous;

public class SumContigousArray {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		int max, k = 3;
		
		for(int i=0; i <= arr.length -k; i++) {
			max = arr[i];
			for(int j=1; j < k; j++) {
				if(arr[i+j]>max) {
					max = arr[i+j];
				}
			}
			
			System.out.println("max: "+max);
		}
	}
}
