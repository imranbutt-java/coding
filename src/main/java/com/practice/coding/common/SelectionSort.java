package com.practice.coding.common;

public class SelectionSort {
    public static void main(String[] args) {
        int[] num = {4,2,1,3,6,5};
        selectionSort(num);
    }

    private static void selectionSort(int[] num) {
        for (int i=0; i<num.length; i++) {
            int min = i;
            for ( int j = i; j<num.length-1; j++) {
                if (num[min] > num[j]) {
                    min = j;
                }
            }
            int tmp = num[min];
            num[min] = num[i];
            num[i] = tmp;
        }
        for(int a: num) {
            System.out.print(a);
        }
    }
}
