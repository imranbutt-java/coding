package com.practice.coding.graph;

import java.util.*;

public class ShortestPath {
    static List<List<Integer>> question = new ArrayList<>();
    static {
        question.add(Arrays.asList(0, 1, 1));
        question.add(Arrays.asList(0, 0, 1));
        question.add(Arrays.asList(0, 0, 1));
        question.add(Arrays.asList(0, 9, 0));
    }
    private static final int DEST = 9;
    private static int dir[][] = {{0,1}, {1,0}, {0,-1}, {-1, 0}};
    /**
     * Start from top left and find the shortest path till 9 is found, we can only move left
     * right, up and down
     * 0    1   1
     * 0    0   9
     * 0    0   1
     * @param matrix
     * @return
     */
    public static List<List<Integer>> findShortesPath(List<List<Integer>> matrix) {

        int R = matrix.size();
        int C = matrix.get(0).size();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<R; i++)
            ans.add(new ArrayList<>(C));
        boolean visited[][] = new boolean[R][C];
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] pop = q.remove();
                if(matrix.get(pop[0]).get(pop[1]) == DEST) {
                    ans.get(pop[0]).add(pop[1], 5);
                    return ans;
                }
                for (int k=0;k<dir.length;k++) {
                    int nextX = dir[k][0]+pop[0];
                    int nextY = dir[k][1]+pop[1];

                    if(nextX>=0 && nextX<R && nextY>=0 && nextY<C && !visited[nextX][nextY] && (matrix.get(nextX).get(nextY)==0 || matrix.get(nextX).get(nextY)==9)) {
                        q.add(new int[]{nextX,nextY});
                        visited[nextX][nextY]=true;
                    }
                }
                ans.get(pop[0]).add(pop[1], 5);
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = findShortesPath(question);
        System.out.println(ans.get(0));
        System.out.println(ans.get(1));
        System.out.println(ans.get(2));
        System.out.println(ans.get(3));
    }
}
