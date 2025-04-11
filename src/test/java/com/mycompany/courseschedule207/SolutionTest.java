package com.mycompany.courseschedule207;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
//        ImprovedSolution solution = new ImprovedSolution();
        ImprovedSolution2 solution = new ImprovedSolution2();
        int[][] prerequisites = new int[][]{{1,0}};
        assertTrue(solution.canFinish(2, prerequisites));

        prerequisites = new int[][]{{1,0}, {0,1}};
        assertFalse(solution.canFinish(2, prerequisites));

//        prerequisites = new int[][]{{1,0}, {1,2}};
//        assertFalse(solution.canFinish(2, prerequisites));

        prerequisites = new int[][]{{1,0}, {1,2}};
        assertTrue(solution.canFinish(3, prerequisites));

//        prerequisites = new int[][]{{1,0}, {1,2}, {2,3}, {3,1}};
//        assertFalse(solution.canFinish(3, prerequisites));

        prerequisites = new int[][]{{1,0}, {1,2}, {2,3}, {3,1}};
        assertFalse(solution.canFinish(4, prerequisites));

        prerequisites = new int[][]{{0,10}};
        assertTrue(solution.canFinish(20, prerequisites));
//
//        prerequisites = new int[][]{{0,10}, {5,5}};
//        assertTrue(solution.canFinish(20, prerequisites));

        prerequisites = new int[][]{{0,10}, {6,11}, {7,1}, {11,14},{13,1}};
        assertTrue(solution.canFinish(20, prerequisites));

        prerequisites = new int[][]{{0,10}, {5,5}, {6,11}, {7,1}, {11,14},{13,1}};
        assertFalse(solution.canFinish(20, prerequisites));

        prerequisites = new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        assertFalse(solution.canFinish(20, prerequisites));

        prerequisites = new int[][]{{0,1}, {0,2}, {1,0}};
        assertFalse(solution.canFinish(3, prerequisites));

        prerequisites = new int[][]{{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}};
        assertTrue(solution.canFinish(8, prerequisites));
    }
}
