package com.practice.coding.practice;

import java.util.*;
import java.lang.*;
import java.io.*;

class MaxTipCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        long results[] = new long[T];
        for (int i = 0; i < T; ++i) {
            int N = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();
            sc.nextLine();
            int a[] = new int[N];
            int b[] = new int[N];
            for (int j = 0; j < N; ++j) {
                a[j] = sc.nextInt();
            }
            sc.nextLine();
            for (int j = 0; j < N; ++j) {
                b[j] = sc.nextInt();
            }
            results[i] = calMaxTip(a, b, X, Y, N);
        }
        for (int i = 0; i < T; ++i) {
            System.out.println(results[i]);
        }

    }

    private static long calMaxTip(int[] a, int[] b, int X, int Y, int N) {
        int arr[][] = new int[N][2];
        for (int i = 0; i < N; ++i) {
            arr[i][0] = a[i];
            arr[i][1] = b[i];
        }
        Arrays.sort(arr, new Comparator<Object>() {
            @Override
            public int compare(Object arg0, Object arg1) {
                int[] o1 = (int[]) arg0;
                int[] o2 = (int[]) arg1;
                int diff1 = o1[0] - o1[1];
                int diff2 = o2[0] - o2[1];
                if (diff1 > diff2) {
                    return 1;
                }
                if (diff1 < diff2) {
                    return -1;
                }
                if (diff1 == diff2) {
                    if (diff1 < 0) {
                        if (o2[1] > o1[1]) {
                            return -1;
                        }
                        if (o2[1] < o1[1]) {
                            return 1;
                        }
                        return 0;
                    } else {
                        if (o1[0] > o2[0]) {
                            return 1;
                        }
                        if (o1[0] < o2[0]) {
                            return -1;
                        }
                        return 0;
                    }
                }
                return 0;
            }
        });


        long result = 0;

//		if(X>Y) {
        //from index N-X to Y-1
        for (int i = N - 1; i > Y - 1; --i) {
            result = result + arr[i][0];
        }
        for (int i = 0; i < N - X; ++i) {
            result = result + arr[i][1];
        }
        for (int i = N - X; i < Y; ++i) {
            result = result + Math.max(arr[i][0], arr[i][1]);
        }
//		}

        return result;
    }
}


