package com.practice.coding.common;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Coor {
    int x,y;
    Coor(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    int getDistance(Coor other) {
        return ((int)Math.sqrt((other.x-x)*(other.x-x) + (other.y-y)*(other.y-y)));
    }
}

class Golf {
	public static void main (String[] args) {
		Integer[][] grid = {{1,1,0,2},
						{3,1,1,1}
                        };
						
        int dist = getDistanceToLevelField(grid, 2, 4);
        System.out.println(dist);
	}
	
	static int getDistanceToLevelField(Integer[][] grid, int rows, int cols) {
	    
	    Map<Integer,Coor> trees = new TreeMap<>();

	    Coor[] corners = {new Coor(0,0), new Coor(0,cols-1), 
	                      new Coor(rows-1,cols-1), new Coor(rows-1,0)};

	    // get all the trees and store in a treeMap. It will do sorted insert based on tree height
	    for(int i=0; i<rows; i++)
	        for(int j=0; j<cols; j++)
	            if(grid[i][j] != 1 && grid[i][j] != 0) {
	                trees.put(grid[i][j], new Coor(i,j));
	            }

		// the first entry in the treeMap is the shortest Tree
        Map.Entry<Integer,Coor> entry = trees.entrySet().iterator().next();
        Coor shortestTreeCoor = new Coor(entry.getValue().x, entry.getValue().y);
		
		// get the corner with the least distance to the shortest tree. 
        int minStartDist = Integer.MAX_VALUE;
        Coor start = null;
        for(int i=0; i<corners.length; i++) {
            int dist = shortestTreeCoor.getDistance(corners[i]);
            if(minStartDist > dist) {
                minStartDist = dist;
                start = corners[i];
            }
        }
        
		// call breadth first search to find all the trees.
        int dist = 0;
        Coor curPos = start;
        while(!trees.isEmpty()) {
            
            Map.Entry<Integer,Coor> SearchTree = trees.entrySet().iterator().next();
            
            dist += bfs(grid, curPos, SearchTree.getKey());
            trees.remove(SearchTree.getKey());
        }

	    return dist;
	}
	
	static int bfs(Integer[][] grid, Coor start, int treeHeight) {
	    
	    int distance[][] = new int[grid.length][grid[0].length];
	    int moves[][] = {{1,0,-1,0},
                         {0,1,0,-1}};
                         
        distance[start.x][start.y] = 1;
        Queue<Coor> queue = new LinkedList<Coor>();
        queue.add(start);
        
        while(!queue.isEmpty()) {
            
            Coor coor = queue.poll();
            int dist = distance[coor.x][coor.y];
            if(grid[coor.x][coor.y] == treeHeight) {
                start.x = coor.x;
                start.y = coor.y;
                return (dist - 1);
            }
            
            for(int i=0; i<moves[0].length; i++) {
                int X = coor.x + moves[0][i];
                int Y = coor.y + moves[1][i];
                
                if(X >= 0 && X < grid.length &&
                   Y >= 0 && Y < grid[0].length &&
                   grid[X][Y] != 0 && distance[X][Y] == 0) {
                       distance[X][Y] = dist + 1;
                       queue.add(new Coor(X,Y));
                   }
            }
            
        }
        return -1;
	}
}
