package com.practice.coding.common;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 */
public class MinCostPath {

	//Go from top left to bottom right
    public int minCost(int [][]cost,int m,int n){
        
        int temp[][] = new int[m+1][n+1];
        int sum = 0;
        //Fill first row like 1 3 6
        for(int i=0; i <= n; i++){
            temp[0][i] = sum + cost[0][i];
            sum = temp[0][i];
        }
        
        /*
         * Fill first column like 
         * 1 3 6
         * 5 0 0
         * 6 0 0
         * 120 0
         * 							
         */
        sum = 0;
        for(int i=0; i <= m; i++){
            temp[i][0] = sum + cost[i][0];
            sum = temp[i][0];
        }
        
        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                temp[i][j] = cost[i][j] + min(temp[i-1][j-1], temp[i-1][j],temp[i][j-1]);
            }
        }
        return temp[m][n];
    }
    
    public int minCostRec(int cost[][], int destX, int destY){
        return minCostRec(cost, destX, destY, 3 , 0);
    }
    
    //Go from bottom left to top right
    public int minCostRec(int cost[][], int destX, int destY, int currentX, int currentY){
        if(currentX < 0 || currentY > destY){
            return Integer.MAX_VALUE;
        }
        if(currentX == destX && currentY == destY){
            return cost[destX][destY];
        }
        
        int t1 = minCostRec(cost, destX , destY, currentX-1, currentY);
        int t2 = minCostRec(cost, destX , destY, currentX-1, currentY+1);
        int t3 = minCostRec(cost, destX , destY, currentX, currentY+1);
        
        return cost[currentX][currentY] + min(t1,t2,t3);
    }
    
    private int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
    
    public static void main(String args[]){
        MinCostPath mcp = new MinCostPath();
        int cost[][] = {{1,2,3},
        				{4,8,2},
        				{1,5,3},
        				{6,2,9}};
        int result = mcp.minCost(cost, 3, 2);
        int result1 = mcp.minCostRec(cost, 0, 2);
        System.out.println(result);
        System.out.println(result1);
    }

}
