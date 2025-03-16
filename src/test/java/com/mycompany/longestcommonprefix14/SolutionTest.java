package com.mycompany.longestcommonprefix14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        String[] input = new String[] {"flower","flow","flight"};
        assertEquals("fl", solution.longestCommonPrefix(input));

        input = new String[]{"dog","racecar","car"};
        assertEquals("", solution.longestCommonPrefix(input));

        input = new String[]{"dog","","car"};
        assertEquals("", solution.longestCommonPrefix(input));

        input = new String[]{"dog","d","dar"};
        assertEquals("d", solution.longestCommonPrefix(input));

        input = new String[]{"dog","dd","dar"};
        assertEquals("d", solution.longestCommonPrefix(input));

        input = new String[]{"","b"};
        assertEquals("", solution.longestCommonPrefix(input));

        input = new String[]{"a","ac"};
        assertEquals("a", solution.longestCommonPrefix(input));

        String a = "";
        System.out.println("print " + a.substring(0,0) + ".");
    }
}
