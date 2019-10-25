package com.practice.coding.common;

public class BinarySearch {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6};
        System.out.println(binarySearch(num, 4, 0, 5, 3));
    }

    private static int binarySearch(int[] num, int findMe, int left, int right, int foundAt) {
        if(left > right) {
            return foundAt;
        }

        foundAt = (left+right)/2;

        if(num[foundAt] == findMe) {
            return foundAt;
        } else if (num[foundAt] > findMe) {
            return binarySearch(num, findMe, left, foundAt-1, foundAt);
        } else {
            return binarySearch(num, findMe, foundAt+1, right, foundAt);
        }
    }
}
