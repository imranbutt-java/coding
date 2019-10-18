package com.practice.coding.graph;

import java.util.*;

public class MinCostPath {
    /**
     * 0    0   0
     * 0    1   0
     * 0    9   0
     * 0    1   0
     *
     * and required output:
     * 0    ,   ,
     * 0    ,   ,
     * 0    9   ,
     * ,    ,   ,
     * @param matrix
     * @return
     */
    public static List<List<Integer>> minCostPath(List<List<Integer>> matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<matrix.size(); i++) {
            ans.add(new ArrayList<>());
        }

        if(matrix.get(0).get(0) != 0) return null;

        Queue<String> toVisit = new LinkedList<>();
        Map<String, String> parents = new HashMap();

        toVisit.add(0+","+0);
        parents.put(0+","+0, null);

        while(!toVisit.isEmpty()) {
            String node = toVisit.poll();

        }


        return ans;
    }

    public static int minimumCost(int N, List<List<int[]>> graph) {
        if (N == 1) return 0;
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new CostComparator());
        int cost = 0, numberOfCitiesVisited = 0;

        queue.offer(new int[] {1, 0});
        while (!queue.isEmpty()) {
            int[] u = queue.poll();
            if (visited[u[0]]) continue;
            visited[u[0]] = true;
            cost += u[1]; //first time visit so cumulate the cost
            numberOfCitiesVisited++;

            for (int[] v : graph.get(u[0])) {
                if (!visited[v[0]]) queue.offer(new int[] {v[0], v[1]});
            }
        }

        return numberOfCitiesVisited == N ? cost : -1;
    }

    private static final class CostComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] x, int[] y) {
            return x[1] - y[1];
        }
    }

    public static void main(String[] args) {
        int[][] m = new int[][] {
                {0,1,1,0,0},
                {0,1,5,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}};
//        System.out.println(shortestPathBinaryMatrix(m));

        List<List<Integer>> m1 = Arrays.asList(
                Arrays.asList(0,0,0,0,0),
                Arrays.asList(0,1,1,5,0),
                Arrays.asList(0,0,0,0,0),
                Arrays.asList(1,1,0,1,1),
                Arrays.asList(0,0,0,0,0));
//        System.out.println(5, minimumCost(m1));
        minCostPath(m1).forEach(x-> System.out.println(x));
    }

}
