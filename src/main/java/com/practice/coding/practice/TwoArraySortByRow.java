package com.practice.coding.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoArraySortByRow<T> {
    public static void main(String[] args) {
        Integer[][] arr = {{2, 1}, {4, 3}};

        sort(arr);
    }

    public void func(T a) {

    }

    public static void sort(Integer[][] arr) {

        for(Integer array[]: arr) {

            Arrays.sort(array, (a, b) -> -1 * Integer.compare(a, b));
            for(int a: array) {
                System.out.print(a);
            }
            System.out.println();
        }
    }
}
