package com.practice.coding.common;

public class MergeSort {
    public static void main(String[] args) {
        int[] num = {4,2,1,3,6,5};
        mergeSort(num, 0, num.length-1);
        for(int a: num) {
            System.out.print(a);
        }
    }

    private static void mergeSort(int[] num, int low, int high) {
        if (low < high) {
           int middle = (low + high) / 2;
           mergeSort(num, low, middle);
           mergeSort(num, middle+1, high);
           mergeSort(num, low, middle, high);
        }
    }

    private static void mergeSort(int[] num, int low, int middle, int high) {
        int[] helper = new int[num.length];
        for (int i = low; i <= high; i++) {
            helper[i] = num[i];
        }

        int helperLeft = low;
        int helperRight = middle+1;
        int current = low;

        while (helperLeft <= middle && helperRight <=high) {
            if(helper[helperLeft] <= helper[helperRight]){
                num[current] = helper[helperLeft];
                helperLeft++;

            }else{
                num[current] = helper[helperRight];
                helperRight++;
            }
            current ++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            num[current+i] = helper[helperLeft+ i];
        }

    }
}
