package com.practice.coding.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenProblem {
	class Position {
        int row, col;
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public Position[] solveNQueenOneSolution(int n) {
        Position[] positions = new Position[n];
        boolean hasSolution = solveNQueenOneSolutionUtil(n, 0, positions);
        if (hasSolution) {
            return positions;
        } else {
            return new Position[0];
        }
    }

    private boolean solveNQueenOneSolutionUtil(int n, int row, Position[] positions) {
        if (n == row) {
            return true;
        }
        int col;
        for (col = 0; col < n; col++) {
            boolean foundSafe = true;

            //check if this row and col is not under attack from any previous queen.
            for (int queen = 0; queen < row; queen++) {
                if (positions[queen].col == col || positions[queen].row - positions[queen].col == row - col ||
                        positions[queen].row + positions[queen].col == row + col) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                positions[row] = new Position(row, col);
                if (solveNQueenOneSolutionUtil(n, row + 1, positions)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     *Solution for https://leetcode.com/problems/n-queens/
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Position[] positions = new Position[n];
        solve(0, positions, result, n);
        return result;
    }

    public void solve(int curentQueen, Position[] positions, List<List<String>> result, int n) {
        if (n == curentQueen) {
            StringBuffer buff = new StringBuffer();
            List<String> oneResult = new ArrayList<>();
            for (Position p : positions) {
                for (int i = 0; i < n; i++) {
                    if (p.col == i) {
                        buff.append("Q");
                    } else {
                        buff.append(".");
                    }
                }
                oneResult.add(buff.toString());
                buff = new StringBuffer();

            }
            result.add(oneResult);
            return;
        }

        //currentQueen or currentRow
        for (int col = 0; col < n; col++) {
            boolean foundSafe = true;
            //if current position isn't suitable with any condition break the queen loop and go for next cell
            for (int prevQueen = 0; prevQueen < curentQueen; prevQueen++) {
                if (positions[prevQueen].col == col || positions[prevQueen].col - positions[prevQueen].row == col - curentQueen || positions[prevQueen].row + positions[prevQueen].col == col + curentQueen) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                positions[curentQueen] = new Position(curentQueen, col);
                solve(curentQueen + 1, positions, result, n);
            }
        }
    }

    public static void main(String args[]) {
        NQueenProblem s = new NQueenProblem();
        Position[] positions = s.solveNQueenOneSolution(4);
        Arrays.stream(positions).forEach(position -> System.out.println(position.row + " " + position.col));
        System.out.println();
        List<List<String>> list = s.solveNQueens(4);
        list.stream().forEach(i->i.stream().forEach(j-> System.out.println(j)));
    }
}