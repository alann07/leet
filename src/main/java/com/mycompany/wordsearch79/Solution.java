package com.mycompany.wordsearch79;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
 * vertically neighboring. The same letter cell may not be used more than once.
 *
 * 175ms Beats 34.44% 41.65MB Beats 61.88%
 */
public class Solution {
    public boolean exist(char[][] board, String word) {

        int[][] visited = new int[board.length][board[0].length];
        return findSolution(board, word, visited, 0, 0, 0, false, true);
    }

    private boolean findSolution(char[][] board, String word, int[][] visited, int index, int row, int col, boolean foundFirstMatch, boolean firstLayer) {
        if (index==word.length() ||
                row <0 ||
                row >= board.length ||
                col >= board[0].length ||
                col < 0 ||
                visited[row][col] == 1) return false;
        if (foundFirstMatch) {
            if (board[row][col] != word.charAt(index)) {
                return false;
            }
            else if (index == word.length()-1){
                return true;
            }
        }
        char currChar = word.charAt(index);
        for(int i=row; i< board.length; i++) {
            for(int j=col; j<board[0].length; j++) {
                if (board[i][j] == currChar) {
                    if (word.length() == 1) return true;
                    foundFirstMatch = true;
                }

                if (foundFirstMatch) {
                    // go searching 4 directions
                    visited[i][j] = 1;
                    if (findSolution(board, word, visited, index+1, i-1, j, foundFirstMatch, false)) return true;
                    if (findSolution(board, word, visited, index+1, i+1, j, foundFirstMatch, false)) return true;
                    if (findSolution(board, word, visited, index+1, i, j+1, foundFirstMatch,false)) return true;
                    if (findSolution(board, word, visited, index+1, i, j-1, foundFirstMatch, false)) return true;
                    visited[i][j] = 0;
                    if (!firstLayer) {
                        return false;
                    }
                    foundFirstMatch = false;
                }
            }
        }
        return false;
    }
}
