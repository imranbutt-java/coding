package com.practice.coding.common;

public class QuickSort {
    public static void main(String[] args) {
        int[] num = {4,2,1,3,6,5};
        quickSort(num, 0, num.length-1);
        for(int a: num) {
            System.out.print(a);
        }
    }

    private static void quickSort(int[] num, int start, int end) {
        if (start >= end) {
            return;
        }
        int pInd = partition(num, start, end);
        quickSort(num, start, pInd-1);
        quickSort(num, pInd+1, end);
    }

    private static int partition(int[] num, int start, int end) {
        int pivot = num[end];
        int pInd = start;
        for(int i=start; i<end; i++) {
            if(num[i] < pivot) {
                int tmp = num[i];
                num[i] = num[pInd];
                num[pInd] = tmp;

                pInd++;
            }
        }

        int tmp = num[pInd];
        num[pInd] = num[end];
        num[end] = tmp;
        return pInd;
    }
}
