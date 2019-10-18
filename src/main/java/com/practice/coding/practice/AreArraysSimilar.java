package com.practice.coding.practice;

import java.util.ArrayList;
import java.util.List;

public class AreArraysSimilar {
    public static void main(String[] args) {
        int a[] = {1, 2, 3};
        int b[] = {2, 1, 3};

        System.out.println(areSimilar(a, b));
    }

    private static boolean areSimilar(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<a.length; i++) {
            if (a[i] != b[i]) {
               list.add(i);
            }
        }

        if(list.size() == 0) {
            return true;
        }

        if(list.size() != 2) {
            return false;
        }

        if(a[list.get(0)] == b[list.get(1)] && a[list.get(1)] == b[list.get(0)]) {
            return true;
        }
        return false;
    }
}
