package com.mycompany.twosum;

import org.junit.jupiter.api.Test;

public class ImprovedSolutionTest {
    @Test
    public void testTwoSum() {
        ImprovedSolution solution = new ImprovedSolution();
        int[] nums = {2, 5, 5, 11};
        int target = 10;
        int[] result = solution.twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
        assert result[0] == 1 && result[1] == 2;
    }

    @Test
    public void testTwoSum2() {
        ImprovedSolution solution = new ImprovedSolution();
        int[] nums = {-10, -5, -2, -1, 1, 2, 5, 5, 11, 15};
        int target = -2;
        int[] result = solution.twoSum(nums, target);
        if (result.length == 2) {
            System.out.println(result[0] + " " + result[1]);
        } else {
            System.out.println("No solution found");
        }
//        assert result[0] == 1 && result[1] == 2;
    }


    @Test
    public void testTwoSum3() {
        ImprovedSolution solution = new ImprovedSolution();
        int[] nums = {-10, -5, -2, -1, 1, 2, 5, 5, 11, 15};
        int target = 10;
        int[] result = solution.twoSum(nums, target);
        if (result.length == 2) {
            System.out.println(result[0] + " " + result[1]);
        } else {
            System.out.println("No solution found");
        }
//        assert result[0] == 1 && result[1] == 2;
    }
}
