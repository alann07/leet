package com.mycompany.sortlist148;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        improvedSolution solution = new improvedSolution();
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode result = solution.sortList(head);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(4, result.next.next.next.val);

        result = solution.sortList(new ListNode());
        assertNull(result.next);

    }
}
