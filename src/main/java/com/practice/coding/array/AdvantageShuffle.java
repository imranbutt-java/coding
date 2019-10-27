package com.practice.coding.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 *
 * 870. Advantage Shuffle
 * Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
 *
 * Return any permutation of A that maximizes its advantage with respect to B.
 *
 * Example 1:
 *
 * Input: A = [2,7,11,15], B = [1,10,4,11]
 * Output: [2,11,7,15]
 */
public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        Arrays.sort(A);
        for(int i=0; i<B.length; i++)
            pq.add(new int[]{B[i], i});

        int[] result = new int[A.length];
        int hi=A.length-1, low = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int ind = curr[1], val = curr[0];
            if(A[hi] > val) result[ind] = A[hi--];
            else result[ind] = A[low++];
        }

        return result;
    }

    public static void main(String[] args) {
        AdvantageShuffle c = new AdvantageShuffle();
        IntStream.of(c.advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11})).forEach(x->System.out.print(x+","));
    }

}
