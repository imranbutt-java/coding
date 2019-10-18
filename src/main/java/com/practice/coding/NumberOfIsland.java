package com.practice.coding;

public class NumberOfIsland {
	public static void main(String args[]) {
		NumberOfIsland ins = new NumberOfIsland();
		int M[][] = new int[][] { { 1, 1, 1, 0, 0 }, 
								  { 0, 1, 0, 0, 1 }, 
								  { 1, 0, 0, 1, 1 }, 
								  { 0, 0, 0, 0, 0 },
								  { 1, 0, 1, 0, 1 } };
		System.out.println(ins.numberOfIsland(M));
	}

	boolean[][] visited = null;
	public int numberOfIsland(int[][] graph) {

		visited = new boolean[graph.length][graph.length];
		int count = 0;
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				if (visited[i][j] == false && graph[i][j] == 1) {
					if(DFS(graph, visited, i, j))
						count++;
				}
			}
		}
		return count;
	}

	private boolean DFS(int[][] graph, boolean[][] visited, int i, int j) {
		if (i < 0 || j < 0 || i == graph.length || j == graph[i].length) {
			return false;

		}
		
		if (graph[i][j] == 0) {
			return false;
		}
		
		if (graph[i][j] == 1 && visited[i][j] == false) {
			return true;
		}
		visited[i][j] = true;
		
		boolean exist = DFS(graph, visited, i-1, j -1) ||
					    DFS(graph, visited, i + 1, j) ||
					    DFS(graph, visited, i + 1, j + 1) ||
					    DFS(graph, visited, i + 1, j - 1) ||
					    DFS(graph, visited, i - 1, j + 1) ||
					    DFS(graph, visited, i - 1, j ) ||
					    DFS(graph, visited, i, j-1 ) ||
					    DFS(graph, visited, i, j+1 );
		return exist;
//		DFS(graph, visited, i - 1, j + 1);
	}
}
