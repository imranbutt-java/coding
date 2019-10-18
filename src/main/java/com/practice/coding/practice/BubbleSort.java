package com.practice.coding.practice;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] num = {4,2,1,3,6,5};
        bubbleSort(num);
    }

    private static void bubbleSort(int[] num) {
        for(int i = 0; i<num.length; i++) {
            boolean flag = false;
            for(int j=0; j<(num.length - i - 1); j++) {
                if(num[j] > num[j+1]) {
                    int tmp = num[j+1];
                    num[j+1] = num[j];
                    num[j] = tmp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
        for(int i:num) {
            System.out.print(i+",");
        }
    }
}
