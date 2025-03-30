package com.mycompany.surroundedregions130;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
//        ImprovedSolution solution = new ImprovedSolution();
        ImprovedSolution2 solution = new ImprovedSolution2();
        char[][] board = new char[][]{{'X'}};
        solution.solve(board);
        assertEquals('X', board[0][0]);

        board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solution.solve(board);
        assertEquals('X', board[1][1]);
        assertEquals('X', board[2][2]);
        assertEquals('O', board[3][1]);

        board = new char[][]{
                {'X','X','O','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};
        solution.solve(board);
        assertEquals('O', board[0][2]);
        assertEquals('O', board[1][1]);
        assertEquals('O', board[2][2]);
        assertEquals('O', board[3][1]);

        board = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','O'},
                {'X','O','X','X'}};
        solution.solve(board);
        assertEquals('X', board[0][2]);
        assertEquals('O', board[1][1]);
        assertEquals('O', board[2][2]);
        assertEquals('O', board[2][3]);
        assertEquals('O', board[3][1]);

        board = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','X','X','X'}};
        solution.solve(board);
        assertEquals('X', board[0][2]);
        assertEquals('X', board[1][1]);
        assertEquals('X', board[2][2]);
        assertEquals('X', board[2][3]);
        assertEquals('X', board[3][1]);
    }
}
