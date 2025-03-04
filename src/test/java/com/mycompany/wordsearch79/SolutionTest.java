package com.mycompany.wordsearch79;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        char[][] board;

        board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        assertEquals(true, solution.exist(board, "SEE"));

        board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        assertEquals(true, solution.exist(board, "ABCCED"));

        board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        assertEquals(false, solution.exist(board, "ABCB"));

        board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        assertEquals(true, solution.exist(board, "FDE"));

        board = new char[][]{{'a'}};
        assertEquals(true, solution.exist(board, "a"));

        board = new char[][]{{'a', 'b'}};
        assertEquals(true, solution.exist(board, "a"));

        board = new char[][]{{'a'}, {'b'}};
        assertEquals(true, solution.exist(board, "b"));
    }
}
