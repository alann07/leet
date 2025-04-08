package com.mycompany.linkedlisthascycle141;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2));
        head.next.next = head;
        assertTrue(solution.hasCycle(head));

        head = new ListNode(3);
        ListNode next = new ListNode(2, new ListNode(0));
        head.next = next;
        next.next.next = next;
        assertTrue(solution.hasCycle(head));

        head = new ListNode(1);
        assertFalse(solution.hasCycle(head));

        head = new ListNode(1, new ListNode(2, new ListNode(3)));
        assertFalse(solution.hasCycle(head));
    }
}
