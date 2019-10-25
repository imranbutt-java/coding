package com.practice.coding.common;

public class InsertionSort {
    public static void main(String[] args) {
        int[] num = {4,2,1,3,6,5};
        insertionSort(num);
    }

    private static void insertionSort(int[] num) {
        for(int i=1; i<num.length; i++) {
            int value = num[i];
            int index = i;
            while(index > 0 && num[index-1] > value) {
                int tmp = num[index-1];
                num[index-1] = value;
                num[index] = tmp;
                index--;
            }
            num[index] = value;
        }
        for(int i:num) {
            System.out.print(i+",");
        }
    }
}
