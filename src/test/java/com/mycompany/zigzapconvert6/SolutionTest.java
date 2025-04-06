package com.mycompany.zigzapconvert6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assertEquals("A", solution.convert("A", 1));
        assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", solution.convert("PAYPALISHIRING", 4));
        assertEquals("acbd", solution.convert("abcd", 2));
        assertEquals("abdc", solution.convert("abcd", 3));
        assertEquals("abcd", solution.convert("abcd", 1));
        assertEquals("acb", solution.convert("abc", 2));
        assertEquals("abc", solution.convert("abc", 5));
        assertEquals("abcde", solution.convert("abcde", 5));
        assertEquals("abcgdfe", solution.convert("abcdefg", 5));
        assertEquals("abhcgdfe", solution.convert("abcdefgh", 5));
        assertEquals("aibhcgdfe", solution.convert("abcdefghi", 5));
        assertEquals("aibhkcgdfe", solution.convert("abcdefghik", 5));
    }
}

