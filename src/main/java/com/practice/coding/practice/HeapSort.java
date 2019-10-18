package com.practice.coding.practice;

public class HeapSort {
    public static void main(String[] args) {
        int[] num = {4,2,1,3,6,5};
        heapSort(num);
        for(int a: num) {
            System.out.print(a);
        }
    }

    private static void heapSort(int[] num) {
        int length = num.length;

        //Build Heap rebuild array
        for (int i=length/2 -1; i>=0; i--) {
            heapify(num, length, i);
        }

        //One by one extract one element from heap
        for (int i=length-1; i>=0; i--) {
            //move current root to end
            int tmp = num[0];
            num[0] = num[i];
            num[i] = tmp;

            //call max heapify on the reduced map
            heapify(num, i, 0);
        }
    }

    private static void heapify(int[] num, int length, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < length && num[l] > num[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < length && num[r] > num[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = num[i];
            num[i] = num[largest];
            num[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(num, length, largest);
        }
    }
}
