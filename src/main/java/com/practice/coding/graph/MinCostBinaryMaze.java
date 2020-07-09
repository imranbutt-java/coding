package com.practice.coding.graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinCostBinaryMaze {
    //    private static final int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
    private static final int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        if(grid[0][0] == 1 || grid[R-1][C-1] == 1) return -1;

        boolean[][] visited = new boolean[R][C];
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] d = q.remove();
                if(grid[d[0]][d[1]] == 5) return ans+1;
                for(int j=0; j<dir.length; j++) {
                    int newR = d[0] + dir[j][0];
                    int newC = d[1] + dir[j][1];

                    if(newR >= 0 && newR < R && newC >= 0 && newC < C && !visited[newR][newC] && (grid[newR][newC] == 0 || grid[newR][newC] == 5)) {
                        q.add(new int[]{newR, newC});
                        visited[newR][newC] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    public static int shortestPathBinaryMatrix(List<List<Integer>> grid) {
        int R = grid.size();
        int C = grid.get(0).size();

        if(grid.get(0).get(0) == 1 || grid.get(R-1).get(C-1) == 1) return -1;

        boolean[][] visited = new boolean[R][C];
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] d = q.remove();
                if(grid.get(d[0]).get(d[1]) == 5) return ans+1;
                for(int j=0; j<dir.length; j++) {
                    int newR = d[0] + dir[j][0];
                    int newC = d[1] + dir[j][1];

                    if(newR >= 0 && newR < R && newC >= 0 && newC < C && !visited[newR][newC] && (grid.get(newR).get(newC) == 0 || grid.get(newR).get(newC) == 5)) {
                        q.add(new int[]{newR, newC});
                        visited[newR][newC] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    public static List<List<Integer>> findPath(List<List<Integer>> grid) {
        int R = grid.size();
        int C = grid.get(0).size();

        if(grid.get(0).get(0) == 1 || grid.get(R-1).get(C-1) == 1) return new ArrayList<>();

        boolean[][] visited = new boolean[R][C];
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> l: grid) {
            ans.add(IntStream.of(new int[grid.get(0).size()])
                    .boxed()
                    .collect(Collectors.toList()));
        }

        HashMap<String, String> parents = new HashMap<>();
        parents.put(0+","+0, null);
        String target = null;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] d = q.remove();
                if (grid.get(d[0]).get(d[1]) == 5) {
                    target = d[0]+","+d[1];
                    break;
                }
                for (int j = 0; j < dir.length; j++) {
                    int newR = d[0] + dir[j][0];
                    int newC = d[1] + dir[j][1];

                    if (newR >= 0 && newR < R && newC >= 0 && newC < C && !visited[newR][newC] && (grid.get(newR).get(newC) == 0 || grid.get(newR).get(newC) == 5)) {
                        q.add(new int[]{newR, newC});
                        visited[newR][newC] = true;
                        parents.put(newR+","+newC, d[0]+","+d[1]);
                    }
                }
            }
        }

        if (parents.get(target) == null) return null;

        // Create the output list and add the path to the list
        String n = target;
        while (n != null) {
            ans.get(Integer.parseInt(n.split(",")[0])).set(Integer.parseInt(n.split(",")[1]), 2);
            n = parents.get(n);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] m = new int[][] {
                {0,1,1,0,0},
                {0,1,5,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}};
        System.out.println(shortestPathBinaryMatrix(m));

        List<List<Integer>> m1 = Arrays.asList(
                Arrays.asList(0,0,0,0,0),
                Arrays.asList(0,1,0,1,0),
                Arrays.asList(0,1,0,5,0),
                Arrays.asList(0,1,0,1,1),
                Arrays.asList(0,0,0,0,0));
        System.out.println(shortestPathBinaryMatrix(m1));
        findPath(m1).forEach(x-> System.out.println(x));
    }
}
