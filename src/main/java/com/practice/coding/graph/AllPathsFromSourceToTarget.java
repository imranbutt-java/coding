package com.practice.coding.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 797
 * 
 * Example:
Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
 * @author imransarwar
 *
 */
public class AllPathsFromSourceToTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		tmp.add(0);
		helper(ans, tmp, graph, 0);
		return ans;
	}

	private void helper(List<List<Integer>> ans, List<Integer> tmp, int[][] graph, int i) {
		if(i == graph.length - 1) {
			ans.add(new ArrayList<>(tmp));
			return;
		}
		
		for(int node: graph[i]) {
			tmp.add(node);
			helper(ans, tmp, graph, node);
			tmp.remove(tmp.size() - 1);
		}
	}
	
	
	public static void main(String args[]) {
		AllPathsFromSourceToTarget c = new AllPathsFromSourceToTarget();
		List<List<Integer>> ans = c.allPathsSourceTarget(new int[][]{{1,2}, {3}, {3}, {}});
		ans.forEach(x->System.out.println(x));
	}
}
