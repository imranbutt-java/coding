package com.practice.coding.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 787. Cheapest Flights Within K Stops
 * There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.
 *
 * Now given all the cities and flights, together with starting city src and the destination dst, your task
 * is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 *
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 */
public class CheapestFlightsKStops_Dijekstra {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //This map has mapping like {src, {{dest, price}, {dest2, price}}}
        //In short from this source src, we have these destinations with the given prices.
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for(int f[]: flights) {
            if(!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }

        //Priority Queue with price
        //This pq ordered with price and it contains {price, city1, remaining stops}
        //In short we have price we have to pay to reach city city1 and we have remaining stops.
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] {0, src, K+1});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int price = curr[0];
            int pos = curr[1];
            int stops = curr[2];

            if(pos == dst) return price;
            if(stops > 0) {
                Map<Integer, Integer> adj = prices.getOrDefault(pos, new HashMap<>());
                //Looking for all path that goes out from the current node
                for(int a: adj.keySet()) {
                    pq.add(new int[]{price + adj.get(a), a, stops - 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CheapestFlightsKStops_Dijekstra c = new CheapestFlightsKStops_Dijekstra();
        System.out.println("Minimum Cost: "+c.findCheapestPrice(3, new int[][] {{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
    }
}
