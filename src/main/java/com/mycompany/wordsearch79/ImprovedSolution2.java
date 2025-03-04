package com.mycompany.wordsearch79;

/**
 * Another solution from forum. it first check whether there's enough chars in board to meet the needs of word. smart.
 * It runs at 20ms, beats 98.38%. Briliant.
 */
public class ImprovedSolution2 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        // Frequency check: If board lacks enough letters, return false early
        if (!canFormWord(board, word)) return false;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == word.charAt(0) && backtrack(i, j, 0, board, word))
                    return true;
        return false;
    }

    public boolean backtrack(int i, int j, int idx, char[][] board, String word) {
        // Base case: if we reached the end of the word
        if (idx == word.length()) return true;

        // Check boundaries and character match
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx))
            return false;

        // Mark cell as visited (modify board temporarily)
        char temp = board[i][j];
        board[i][j] = '#';

        // Try all four directions (optimized order)
        boolean found = backtrack(i + 1, j, idx + 1, board, word) || // Down
                backtrack(i - 1, j, idx + 1, board, word) || // Up
                backtrack(i, j + 1, idx + 1, board, word) || // Right
                backtrack(i, j - 1, idx + 1, board, word);   // Left

        // Restore the board after backtracking
        board[i][j] = temp;
        return found;
    }

    // Helper function to check if board contains enough characters to form the word
    public boolean canFormWord(char[][] board, String word) {
        int[] boardFreq = new int[128]; // Increase size to handle all characters
        int[] wordFreq = new int[128];

        for (char[] row : board)
            for (char ch : row)
                boardFreq[ch]++; // Count letters in board

        for (char ch : word.toCharArray())
            wordFreq[ch]++; // Count letters in word

        // If the board lacks enough of any letter, return false early
        for (int i = 0; i < 128; i++)
            if (wordFreq[i] > boardFreq[i]) return false;
        return true;
    }
}

