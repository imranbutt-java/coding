package com.practice.coding.practice;

import java.util.Arrays;
import java.util.List;

/**
 * In an array numbers are increasing and at some point they start decreasing find the point where that happens
 */
public class SearchApexPoint {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 2, 2, 2);
        System.out.println(findIndexOfApexPoint(list, list.size()/2, 0, 6));
    }

    private static int findIndexOfApexPoint(List<Integer> list, int foundAt, int left, int right) {
        if(left == right) {
            return foundAt;
        }
        if(list.get(foundAt) > list.get(foundAt-1) && list.get(foundAt) > list.get(foundAt+1)) {
            return foundAt;
        }
        foundAt = (left + right) / 2;

        if (list.get(foundAt) >= list.get(foundAt-1)) {
           return findIndexOfApexPoint(list, foundAt, foundAt-1, right);
        } else {
            return findIndexOfApexPoint(list, foundAt, left, foundAt+1);
        }
    }
}
