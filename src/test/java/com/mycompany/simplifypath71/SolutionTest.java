package com.mycompany.simplifypath71;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assertEquals("/home", solution.simplifyPath("/home/"));
        assertEquals("/home/foo", solution.simplifyPath("/home//foo/"));
        assertEquals("/home/foo", solution.simplifyPath("/home//foo/"));
        assertEquals("/home/user/Pictures", solution.simplifyPath("/home/user/Documents/../Pictures"));
        assertEquals("/", solution.simplifyPath("/../"));
        assertEquals("/", solution.simplifyPath("/dd//../../"));
        assertEquals("/.../b/d", solution.simplifyPath("/.../a/../b/c/../d/./"));
    }
}
