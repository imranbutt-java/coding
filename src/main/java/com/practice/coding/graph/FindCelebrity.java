package com.practice.coding.graph;

/**
 * 277. Find the Celebrity
 *
 * Input: graph = [
 *   [1,1,0],
 *   [0,1,0],
 *   [1,1,1]
 * ]
 * Output: 1
 * Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j,
 * otherwise graph[i][j] = 0 means person i does not know person j.
 * The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.
 */
public class FindCelebrity {
    public int findCelebrity(int[][] graph, int n) {
        int celebrity = 0;
        for(int i=1; i<n; i++) {
            if(knows(celebrity, i, graph))
                celebrity = i;
        }

        for(int i=0; i<n; i++) {
            if(i != celebrity && (knows(celebrity, i, graph) || !knows(i, celebrity, graph))) {
                return -1;
            }
        }
        return celebrity;
    }

    /**
     * It means i knows celebrity
     * @param i
     * @param celebrity
     * @param graph
     * @return
     */
    private boolean knows(int i, int celebrity, int[][] graph) {
        return graph[i][celebrity] == 1;
    }

    public static void main(String[] args) {
        FindCelebrity c = new FindCelebrity();
        System.out.println(c.findCelebrity(new int[][] {{1,0,1},{0,1,1},{0,0,1}}, 3));
    }
}
