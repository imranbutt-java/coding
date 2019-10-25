package com.practice.coding.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayHasDuplicates {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        System.out.println(hasDuplicates(a));
        List<Integer> l = new ArrayList<>();
        l.add(2000, 2);
    }

    private static boolean hasDuplicates(int[] a) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<a.length; i++) {
            if(!set.add(a[i])) {
                return true;
            }
        }
        return false;
    }
}
